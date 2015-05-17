/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;


public class Dao<T> {

    protected static EntityManager em = Persistence.createEntityManagerFactory("UP").createEntityManager();
    protected EasyCriteria<T> criteria;
    private Class classe;

    public Class getClasse() {
        return classe;
    }

    public Dao(Class classe) {
        this.classe = classe;
    }

    /* Description:
     * O método insert() serve para inserir um objeto no banco de dados
     */
    public void insert(T entidade) {
        em.getTransaction().begin();
        em.persist(entidade);
        em.setFlushMode(FlushModeType.COMMIT);
        em.flush();
        em.getTransaction().commit();
    }

    /* Description:
     * O método update() serve para editar um objeto no banco de dados
     */
    public void update(T entidade) {
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    /* Description:
     * O método remove() serve para remover um objeto no banco de dados
     */
    public void remove(int id) {
        T entidade = get(id);
        if (entidade == null) {
            return;
        }
        em.getTransaction().begin();
        em.remove(entidade);
        em.getTransaction().commit();

    }

    /* Description:
     * O método get() serve para ler um objeto no banco de dados
     */
    public T get(int id) {
        return (T) em.find(classe, id);
    }

    /* Description:
     * O método list() serve para listar todos os elementos dessa entidade
     * no banco de dados
     */
    public List<T> list() {
        newCriteria();
        return this.criteria.getResultList();
    }

    /* Description:
     * Cria um novo criteria para realizar uma nova consulta no banco de dados.
     */
    public void newCriteria(){
        this.criteria = EasyCriteriaFactory.createQueryCriteria(em, classe);
    }
}
