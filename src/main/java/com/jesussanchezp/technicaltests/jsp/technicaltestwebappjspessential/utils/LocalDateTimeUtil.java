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

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Named
@ApplicationScoped
public class LocalDateTimeUtil {

  public int getCurrentYear() {
    return LocalDateTime.now().getYear();
  }

  public String formatter(LocalDateTime localDateTime, String pattern) {
    return localDateTime.atZone(ZoneId.of("America/Mexico_City")).format(DateTimeFormatter.ofPattern(pattern));
  }
}
