package com.startup.bar.modules.tables.api;


import com.startup.bar.crosscutting.dto.TableDto;
import com.startup.bar.crosscutting.exception.PersonalException;
import com.startup.bar.crosscutting.persistence.entity.ProductsConsumed;
import com.startup.bar.crosscutting.persistence.entity.Table;
import com.startup.bar.modules.tables.usecase.ProcessTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/tables",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
@CrossOrigin("*")
public class TablesWebApi {

    @Autowired
    private ProcessTables process;

    @PostMapping("/table")
    public Table saveTable(@RequestBody Table table) {
        return process.auditTables(table);
    }

    @PostMapping("/closeTable")
    public Table closeTable(@RequestParam String nameTable) throws PersonalException {
        return process.closeTable(nameTable);
    }
}
