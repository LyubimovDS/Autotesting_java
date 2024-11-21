#language: ru

Функционал: Проверка работы вебтаблицы
  Сценарий: Открыть страницу
    * Открыть страницу

  Сценарий: Добавить в таблицу персону
    Дано Таблица с персоналом
    И Добавить персону
      |First Name|Last Name|Email       |Age|Salary|Department|
      |First Name|Last Name|name@mail.ru| 18|   100|Department|
    Тогда В таблице должен быть персонал
      |First Name|Last Name|Age|       Email|Salary|Department|
      |First Name|Last Name| 18|name@mail.ru|   100|Department|


  Сценарий: Изменить персону в таблице
    Дано Персона с почтой "name@mail.ru"
    И Изменить персону с почтой "name@mail.ru"
      |      First Name|      Last Name|            Email|Age|Salary|     Department|
      |Other First Name|Other Last Name|othername@mail.ru| 20|   200|OtherDepartment|
    Тогда В таблице должен быть персонал
      |      First Name|      Last Name|Age|            Email|Salary|     Department|
      |Other First Name|Other Last Name| 20|othername@mail.ru|   200|OtherDepartment|


  Сценарий: Удалить персону
    Дано Персона с почтой "othername@mail.ru"
    И Удалить персону с почтой "othername@mail.ru"
    Тогда Не должно быть персоны с почтой "othername@mail.ru"
