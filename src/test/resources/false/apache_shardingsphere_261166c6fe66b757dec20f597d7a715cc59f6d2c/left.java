/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.sql.dialect.handler.ddl;

import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.ddl.MySQLCreateTableStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.opengauss.ddl.OpenGaussCreateTableStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.oracle.ddl.OracleCreateTableStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.postgresql.ddl.PostgreSQLCreateTableStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.sql92.ddl.SQL92CreateTableStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.sqlserver.ddl.SQLServerCreateTableStatement;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class CreateTableStatementHandlerTest {

    @Test
    public void assertIfNotExists() {
        assertTrue(CreateTableStatementHandler.ifNotExists(new MySQLCreateTableStatement(true)));
        assertFalse(CreateTableStatementHandler.ifNotExists(new MySQLCreateTableStatement(false)));
        assertTrue(CreateTableStatementHandler.ifNotExists(new PostgreSQLCreateTableStatement(true)));
        assertFalse(CreateTableStatementHandler.ifNotExists(new PostgreSQLCreateTableStatement(false)));
        assertTrue(CreateTableStatementHandler.ifNotExists(new OpenGaussCreateTableStatement(true)));
        assertFalse(CreateTableStatementHandler.ifNotExists(new OpenGaussCreateTableStatement(false)));
        assertFalse(CreateTableStatementHandler.ifNotExists(new OracleCreateTableStatement()));
        assertFalse(CreateTableStatementHandler.ifNotExists(new SQLServerCreateTableStatement()));
        assertFalse(CreateTableStatementHandler.ifNotExists(new SQL92CreateTableStatement()));
    }
}
