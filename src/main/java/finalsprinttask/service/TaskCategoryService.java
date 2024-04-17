package finalsprinttask.service;

import finalsprinttask.exception.TrelloNotFoundException;
import finalsprinttask.model.TaskCategory;
import finalsprinttask.repository.TaskCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskCategoryService {
    private final TaskCategoryRepository taskCategoryRepository;
    /**
     * Метод для добавления категории задач
     * @param taskCategory - данные из формы ввода
     * @return - возвращаем сохраненную в бд категорию
     */
    public TaskCategory create(TaskCategory taskCategory) {
        log.info("Началось создание категории: {}", taskCategory);
        //TODO: надо добавить проверку на наличие такой категории в БД

        TaskCategory saved = taskCategoryRepository.save(taskCategory);

        log.info("Завершено сохранение новой категории ID: {}", saved.getId());
        return saved;
    }

    /**
     * Метод для изменения категории
     * @param taskCategory - изменная категория из формы ввода
     * @return - возвращаем измененную категорию
     */
    public TaskCategory update(TaskCategory taskCategory) {
        log.info("Началось обновление категории: {}", taskCategory);

        TaskCategory updated = taskCategoryRepository.save(taskCategory);

        log.info("Категория обновилась");
        return updated;
        }

    /**
     * Метод для удаления категории
     * @param id - ИД категории
     */
    public void delete(Long id) {
        log.info("Удаляем категорию: {}", id);

        taskCategoryRepository.deleteById(id);

        log.info("удалили категорию: {}", id);
    }

    /**
     * Метод для получения всех категории
     * @return - возвращаем список всех категории
     */
    public List<TaskCategory> getCategories() {
        log.info("Получение всех категории");
        List<TaskCategory> result = taskCategoryRepository.findAll();
        log.info("Получил все категории");
        return result;
    }

    /**
     * Получение категории по ИД
     * @param Id - ИД категории
     * @return - возвращаеи категорию по ИД
     */
    public TaskCategory getById(Long Id) throws TrelloNotFoundException {
        log.info("Получение категории по ИД");
        TaskCategory result = taskCategoryRepository.findById(Id).orElse(null);
        if(result == null) {
            String message = String.format("TaskCategoryId:%s NOT FOUND", Id);
            throw new TrelloNotFoundException(message);
        }
        log.info("Получил категорию по ИД");
        return result;
    }
}


