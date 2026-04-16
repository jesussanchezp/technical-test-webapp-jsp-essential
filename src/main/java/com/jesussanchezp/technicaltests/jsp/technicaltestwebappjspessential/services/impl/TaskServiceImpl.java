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

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.services.impl;

import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.models.TaskModel;
import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.repositories.TaskRepository;
import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.services.TaskService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;
import org.slf4j.Logger;

@Singleton
public class TaskServiceImpl implements TaskService {

  private final Logger logger;
  private final TaskRepository taskRepository;

  @Inject
  public TaskServiceImpl(Logger logger, TaskRepository taskRepository) {
    this.logger = logger;
    this.taskRepository = taskRepository;
  }

  @Override
  public List<TaskModel> findAll() {
    return this.taskRepository.findAll();
  }

  @Override
  public TaskModel findById(long id) {
    return this.taskRepository.findById(id);
  }

  @Override
  public void save(TaskModel taskModel) {
    this.taskRepository.save(taskModel);
  }

  @Override
  public void update(TaskModel taskModel) {
    this.taskRepository.update(taskModel);
  }

  @Override
  public void delete(long id) {
    this.taskRepository.delete(id);
  }
}
