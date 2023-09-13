# REST API для вычисления частоты встречи символов

Этот REST API предоставляет возможность вычислить частоту встречи символов в заданной строке и вернуть результат, отсортированный по убыванию количества вхождений символа.

## Запуск приложения

1. Склонируйте репозиторий:

   ```
   git clone [https://github.com/illler/StringApi]
   ```

2. Перейдите в каталог приложения:

   ```
   cd string-api
   ```

3. Запустите приложение с помощью Maven:

   ```
   mvn spring-boot:run
   ```

Приложение будет доступно по адресу `http://localhost:8080`.

## Методы API

### Вычисление частоты встречи символов

**URL:** `/api/v1/send-string`

**Метод:** POST

**Тело запроса (Request Body):**
```json
{
  "string": "aaaaabcccc",
  "isLowerCase": "true",
  "isContainsSpace": "true"
}
```

- `string` (обязательный): Строка, для которой будет вычислена частота символов.
- `toLowerCase` (опциональный): Преобразовать строку в нижний регистр (true/false, по умолчанию true).
- `containsSpace` (опциональный): Будут ли воприниматься пробелы как отдельные символы (true/false, по умолчанию true).

**Ответ (Response):**
```json
{
  "a": 5,
  "c": 4,
  "b": 1
}
```
## Формат исходящих параметров

- JSON-объект, где ключи - символы, а значения - количество вхождений символа в заданную строку. Результат отсортирован по убыванию количества вхождений.
