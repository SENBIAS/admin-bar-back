package com.startup.bar.modules.tables.dataprovider.crudrepository;

import com.startup.bar.crosscutting.dto.TableDto;
import com.startup.bar.crosscutting.exception.PersonalException;
import com.startup.bar.crosscutting.persistence.entity.ProductsConsumed;
import com.startup.bar.crosscutting.persistence.entity.Table;
import com.startup.bar.crosscutting.persistence.entity.TableAuditoria;
import com.startup.bar.crosscutting.persistence.repository.AuditoriaRepository;
import com.startup.bar.crosscutting.persistence.repository.BarTablesRepository;
import com.startup.bar.modules.tables.dataprovider.TablesDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CrudTablesDataProvider implements TablesDataProvider {

    @Autowired
    private BarTablesRepository repository;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public Table saveTable(Table table) {
        Boolean price = true;
        Boolean gain = false;
        String nameTable = table.getNameTable();
        Optional<Table> tableExist = repository.findByNameTable(nameTable);
        if(tableExist.isEmpty()) {
            table.setFechaEntrada(LocalDateTime.now().minusHours(5));
            table.setPrice(add(table.getProductsConsumed(), price));
            table.setGain(add(table.getProductsConsumed(), gain));
            return repository.save(table);
        } else {
            Table tableEdit = tableExist.get();
            tableEdit.setProductsConsumed(table.getProductsConsumed());
            tableEdit.setPrice(add(tableEdit.getProductsConsumed(), price));
            tableEdit.setGain(add(tableEdit.getProductsConsumed(), gain));
            return repository.save(tableEdit);
        }

    }

    @Override
    public Table closeTable(String nameTable) throws PersonalException {
        Optional<Table> tableExist = repository.findByNameTable(nameTable);

        if(tableExist.isPresent()) {
            TableAuditoria auditoriaSave = new TableAuditoria();

            auditoriaSave.setId(tableExist.get().getId());
            auditoriaSave.setNameTable(tableExist.get().getNameTable());
            auditoriaSave.setProductsConsumed(tableExist.get().getProductsConsumed());
            auditoriaSave.setPrice(tableExist.get().getPrice());
            auditoriaSave.setGain(tableExist.get().getGain());
            auditoriaSave.setFechaEntrada(tableExist.get().getFechaEntrada());
            auditoriaSave.setFechaSalida(LocalDateTime.now().minusHours(5));
            auditoriaRepository.save(auditoriaSave);
            repository.delete(tableExist.get());
            return tableExist.get();
        } else {
            throw new PersonalException("No existe esta mesa o no tiene pedidos");
        }
    }

    private Integer add(List<ProductsConsumed> productsConsumed, Boolean selector) {
        Integer add = 0;
        for (ProductsConsumed product : productsConsumed) {
            if (selector) {
                add += product.getPrice();
            } else {
                add += product.getGain();
            }
        }

        return add;
    }
}
