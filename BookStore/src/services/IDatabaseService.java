/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author Quang Phat
 */
public interface IDatabaseService {

    List<String> loadData();

    boolean saveData(List<String> entityStringList);

    boolean insert(String entityString);

    boolean update(String entityString);

    boolean delete(String id);
}
