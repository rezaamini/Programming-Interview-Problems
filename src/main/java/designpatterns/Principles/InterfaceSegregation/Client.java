/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.Principles.InterfaceSegregation;

/**
 *
 * @author rezaamini
 */
public class Client {
    IWorkable worker;
    
    public void setWorker(IWorkable w)
    {
        worker = w;
    }
    
    public void work()
    {
        worker.work();
    }
}
