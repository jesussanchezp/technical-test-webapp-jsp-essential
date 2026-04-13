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

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.repositories;

import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.models.TaskModel;
import java.util.List;

public interface TaskRepository {

  List<TaskModel> findAll();

  TaskModel findById(long id);

  void save(TaskModel taskModel);

  void update(TaskModel taskModel);

  void delete(long id);
}
