/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author altuga
 */
@Entity
public class Ping {
    
    @Id
    @GeneratedValue
    public long id;
    
    
    public String name; 
    
}
