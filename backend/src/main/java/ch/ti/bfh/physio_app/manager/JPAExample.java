package ch.ti.bfh.physio_app.manager;

import ch.ti.bfh.physio_app.concept.Exercise;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;


public class JPAExample {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public static void main(String[] args) {
        JPAExample example = new JPAExample();
        System.out.println("After Sucessfully insertion ");
        Exercise exercise1 = example.saveExercise("exercise 1", "type 1");
        Exercise exercise2 = example.saveExercise("exercise 2", "type 2");
        example.listExercise();
        System.out.println("After Sucessfully modification ");
        example.updateExercise(exercise1.getId(), "Exercise 1 Upper");
        example.updateExercise(exercise2.getId(), "Exercise 2 Upper");
        example.listExercise();
        System.out.println("After Sucessfully deletion ");
        example.deleteExercise(exercise2.getId());
        example.listExercise();


    }

    public Exercise saveExercise(String name,String type) {
        Exercise exercise = new Exercise();
        try {
            entityManager.getTransaction().begin();
            exercise.setName(name);
            exercise.setType(type);
            exercise = entityManager.merge(exercise);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return exercise;
    }

    public void listExercise() {
        try {
            entityManager.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<Exercise> Students = entityManager.createQuery("from Exercise").getResultList();
            for (Iterator<Exercise> iterator = Students.iterator(); iterator.hasNext();) {
                Exercise exercise = (Exercise) iterator.next();
                System.out.println("Name : " + exercise.getName() + " Type : " + exercise.getType());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void updateExercise(Long exerciseID, String name) {
        try {
            entityManager.getTransaction().begin();
            Exercise student = (Exercise) entityManager.find(Exercise.class, exerciseID);
            student.setName(name);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteExercise(Long exerciseID) {
        try {
            entityManager.getTransaction().begin();
            Exercise student = (Exercise) entityManager.find(Exercise.class, exerciseID);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
