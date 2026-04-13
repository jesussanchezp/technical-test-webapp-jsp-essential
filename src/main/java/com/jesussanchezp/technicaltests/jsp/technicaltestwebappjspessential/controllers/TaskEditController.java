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

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.controllers;

import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.models.TaskModel;
import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.services.TaskService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/tasks/edit")
public class TaskEditController extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(TaskEditController.class);

  @Inject private TaskService taskService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.valueOf(req.getParameter("id"));
    logger.info("Task Id: {} to Edit", id);
    TaskModel taskModel = this.taskService.findById(id);
    logger.info("Task {} to Edit", taskModel.getTitle());
    req.setAttribute("title", "Editar Tarea");
    req.setAttribute("isError", "false");
    req.setAttribute("task", taskModel);
    req.getRequestDispatcher("/WEB-INF/views/task-edit.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    TaskModel taskModel = new TaskModel();
    taskModel.setId(Long.valueOf(req.getParameter("id")));
    taskModel.setTitle(req.getParameter("title"));
    taskModel.setDescription(req.getParameter("description"));
    taskModel.setStatus(req.getParameter("status"));
    this.taskService.update(taskModel);
    resp.sendRedirect(req.getContextPath() + "/tasks");
  }
}
