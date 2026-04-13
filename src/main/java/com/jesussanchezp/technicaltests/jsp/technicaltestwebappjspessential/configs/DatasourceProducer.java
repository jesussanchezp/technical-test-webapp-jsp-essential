/*
 * Copyright 2026 Jesús Guillermo Sánchez Peralta. <https://jesussanchezp.com>
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

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ApplicationScoped
public class DatasourceProducer {

  @Produces
  @ApplicationScoped
  public DataSource produceDataSource() {
    try {
      return (DataSource)
          new InitialContext().lookup("java:comp/env/jdbc/technical-test-webapp-jsp-essential");
    } catch (NamingException ex) {
      throw new RuntimeException("No se pudo obtener el DataSource JNDI", ex);
    }
  }
}
