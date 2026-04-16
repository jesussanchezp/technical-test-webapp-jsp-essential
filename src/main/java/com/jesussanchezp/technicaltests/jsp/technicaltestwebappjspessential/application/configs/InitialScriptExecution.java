/*
 * Copyright (c) 2026 Jesús Guillermo Sánchez Peralta <https://jesussanchezp.com>. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.application.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.slf4j.Logger;

@ApplicationScoped
public class InitialScriptExecution {

  private final Logger logger;
  private final DataSource dataSource;

  @Inject
  public InitialScriptExecution(Logger logger, DataSource dataSource) {
    this.logger = logger;
    this.dataSource = dataSource;
  }

  public void init(@Observes @Initialized(ApplicationScoped.class) Object initEvent) {
    logger.info("Inicializando base de datos…");
    try (Connection connection = dataSource.getConnection()) {
      connection.setAutoCommit(false);
      this.runScript(connection, "database/schema.sql");
      this.runScript(connection, "database/data.sql");
      connection.commit();
      logger.info("Base de datos inicializada correctamente.");
    } catch (Exception ex) {
      logger.error("Error inicializando la base de datos: {}", ex.getMessage(), ex);
      throw new RuntimeException("Error inicializando la base de datos", ex);
    }
  }

  private void runScript(Connection connection, String path) throws Exception {
    logger.info("Ejecutando script.jsp: {}", path);
    try (BufferedReader reader =
        new BufferedReader(
            new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)))) {
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line).append("\n");
      }
      String sql =
          sb.toString()
              .replaceAll("/\\*[\\s\\S]*?\\*/", " ")
              .replaceAll("--.*?\\n", " ")
              .replaceAll("#.*?\\n", " ")
              .replaceAll("\\n+", "\n");
      for (String statement : sql.split(";")) {
        String trimmed = statement.trim();
        if (!trimmed.isEmpty()) {
          try (Statement st = connection.createStatement()) {
            st.execute(trimmed);
          }
        }
      }
    }
  }
}
