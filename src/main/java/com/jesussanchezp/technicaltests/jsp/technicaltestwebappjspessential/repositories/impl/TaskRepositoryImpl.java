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

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.repositories.impl;

import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.models.TaskModel;
import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.repositories.TaskRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class TaskRepositoryImpl implements TaskRepository {

  private static final Logger logger = LoggerFactory.getLogger(TaskRepositoryImpl.class);

  @Inject private DataSource dataSource;

  @Override
  public List<TaskModel> findAll() {
    List<TaskModel> taskModelList = new ArrayList<>();
    try (Connection connection = this.dataSource.getConnection();
        PreparedStatement preparedStatement =
            connection.prepareStatement("SELECT * FROM TASKS ORDER BY id ASC");
        ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        TaskModel taskModel = new TaskModel();
        taskModel.setId(resultSet.getLong("id"));
        taskModel.setTitle(resultSet.getString("title"));
        taskModel.setDescription(resultSet.getString("description"));
        taskModel.setStatus(resultSet.getString("status"));
        taskModel.setCreatedAt(resultSet.getObject("created_at", LocalDateTime.class));
        taskModelList.add(taskModel);
      }
    } catch (SQLException ex) {
      logger.error("Error en la ejecución del query: {}", ex.getMessage(), ex);
      throw new RuntimeException("Error en la ejecución del query", ex);
    }
    return taskModelList;
  }

  @Override
  public TaskModel findById(long id) {
    try (Connection connection = this.dataSource.getConnection();
        PreparedStatement preparedStatement =
            connection.prepareStatement("SELECT * FROM TASKS WHERE id=?")) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        TaskModel taskModel = new TaskModel();
        taskModel.setId(resultSet.getLong("id"));
        taskModel.setTitle(resultSet.getString("title"));
        taskModel.setDescription(resultSet.getString("description"));
        taskModel.setStatus(resultSet.getString("status"));
        taskModel.setCreatedAt(resultSet.getObject("created_at", LocalDateTime.class));
        return taskModel;
      }
    } catch (Exception ex) {
      logger.error("Error en la ejecución del query: {}", ex.getMessage(), ex);
      throw new RuntimeException("Error en la ejecución del query", ex);
    }
    return null;
  }

  @Override
  public void save(TaskModel taskModel) {
    try (Connection connection = this.dataSource.getConnection();
        PreparedStatement preparedStatement =
            connection.prepareStatement("INSERT INTO TASKS (title, description) VALUES (?, ?)")) {
      preparedStatement.setString(1, taskModel.getTitle());
      preparedStatement.setString(2, taskModel.getDescription());
      preparedStatement.executeUpdate();
    } catch (Exception ex) {
      logger.error("Error en la ejecución del query: {}", ex.getMessage(), ex);
      throw new RuntimeException("Error en la ejecución del query", ex);
    }
  }

  @Override
  public void update(TaskModel taskModel) {
    try (Connection connection = this.dataSource.getConnection();
        PreparedStatement preparedStatement =
            connection.prepareStatement(
                "UPDATE TASKS SET title=?, description=?, status=? WHERE id=?")) {
      preparedStatement.setString(1, taskModel.getTitle());
      preparedStatement.setString(2, taskModel.getDescription());
      preparedStatement.setString(3, taskModel.getStatus());
      preparedStatement.setLong(4, taskModel.getId());
      logger.info("Task to Update: {}", taskModel);
      preparedStatement.executeUpdate();
    } catch (Exception ex) {
      logger.error("Error en la ejecución del query: {}", ex.getMessage(), ex);
      throw new RuntimeException("Error en la ejecución del query", ex);
    }
  }

  @Override
  public void delete(long id) {
    try (Connection connection = this.dataSource.getConnection();
        PreparedStatement preparedStatement =
            connection.prepareStatement("DELETE FROM TASKS WHERE id=?")) {
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
    } catch (Exception ex) {
      logger.error("Error en la ejecución del query: {}", ex.getMessage(), ex);
      throw new RuntimeException("Error en la ejecución del query", ex);
    }
  }
}
