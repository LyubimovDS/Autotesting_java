#language: ru

Функционал: Проверка работы вебтаблицы
  Сценарий: Открыть страницу
    * Открыть страницу

  Сценарий: Добавить в таблицу персону
    Дано Таблица с персоналом
    И Добавить персону
      |First Name|Last Name|Email|Age|Salary|Department|
      |First Name|Last Name|name@mail.ru|18|100|Department|
    Тогда В таблице должен быть персонал
      |First Name|Last Name|Age|Email|Salary|Department|
      |Cierra|Vega|39|cierra@example.com|10000|Insurance|
      |Alden|Cantrell|45|alden@example.com|12000|Compliance|
      |Kierra|Gentry|29|kierra@example.com|2000|Legal|
      |First Name|Last Name|18|name@mail.ru|100|Department|


  Сценарий: Изменить персону в таблице
    Дано Персона с почтой "name@mail.ru"
    И Изменить персону
      |First Name|Last Name|Email|Age|Salary|Department|
      |Other First Name|Other Last Name|name@mail.ru|20|200|OtherDepartment|
    Тогда В таблице должен быть персонал
      |First Name|Last Name|Age|Email|Salary|Department|
      |Cierra|Vega|39|cierra@example.com|10000|Insurance|
      |Alden|Cantrell|45|alden@example.com|12000|Compliance|
      |Kierra|Gentry|29|kierra@example.com|2000|Legal|
      |Other First Name|Other Last Name|20|name@mail.ru|200|OtherDepartment|


  Сценарий: Удалить персону
    Дано Персона с почтой "name@mail.ru"
    И Удалить персону с почтой "name@mail.ru"
    Тогда В таблице должен быть персонал
      |First Name|Last Name|Age|Email|Salary|Department|
      |Cierra|Vega|39|cierra@example.com|10000|Insurance|
      |Alden|Cantrell|45|alden@example.com|12000|Compliance|
      |Kierra|Gentry|29|kierra@example.com|2000|Legal|
    И Не должно быть персоны с почтой "name@mail.ru"
