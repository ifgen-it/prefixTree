# prefixTree

Задание
Есть большой текстовый файл, в котором хранятся различные слова,
некоторые из которых - по многу раз.
Нужно сделать класс WordIndex (можно создавать и другие сопутствующие
классы, если это необходимо), который по сути будет являться индексом.
Он должен позволять по заданному слову находить все вхождения (позиции)
его в файле.

Данный класс должен компилироваться (исполняться) и иметь следующие
методы:

- public void loadFile(String filename) - загрузка данных из файла
и построение индекса;
- public Set<Integer> getIndexes4Word(String searchWord) - возвращает
список позиций слова в файле. Если данного слова нет, то возвращается
null.
  
Для хранения данных в памяти предлагается использовать Trie (префиксное
дерево).

Итог:
Должен получиться Java-проект, в котором будет возможность запустить
Unit-тест и проверить его работоспособность.

Условия:
1. Префиксное дерево нужно реализовать самому;
2. Поиск должен быть регистро-зависимым;
3. Кодировка файла: UTF-8;
4. Система сборки: Maven.
