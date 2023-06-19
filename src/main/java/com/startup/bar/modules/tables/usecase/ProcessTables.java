package com.startup.bar.modules.tables.usecase;

import com.startup.bar.crosscutting.dto.TableDto;
import com.startup.bar.crosscutting.exception.PersonalException;
import com.startup.bar.crosscutting.persistence.entity.Table;
import com.startup.bar.modules.tables.dataprovider.TablesDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static java.util.Map.entry;

@Service
public class ProcessTables {

    @Autowired
    private TablesDataProvider repository;
    public Table auditTables(Table table) {
        return repository.saveTable(table);
    }

    public Table closeTable(String nameTable) throws PersonalException {
        return repository.closeTable(nameTable);
    }
}
