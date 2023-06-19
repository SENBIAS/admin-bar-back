package com.startup.bar.modules.tables.dataprovider;

import com.startup.bar.crosscutting.dto.TableDto;
import com.startup.bar.crosscutting.exception.PersonalException;
import com.startup.bar.crosscutting.persistence.entity.Table;

public interface TablesDataProvider {

    public Table saveTable(Table table);
    public Table closeTable(String nameTable) throws PersonalException;
}
