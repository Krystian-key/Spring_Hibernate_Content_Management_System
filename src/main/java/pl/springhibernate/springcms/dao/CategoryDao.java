package pl.springhibernate.springcms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.springhibernate.springcms.entity.Category;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }



    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }



    public void update(Category category) {
        entityManager.merge(category);
    }



    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }

    public List<Category> getAll() {
        Query query = this.entityManager.createQuery("SELECT g from Category g");
        return query.getResultList();
    }
}

