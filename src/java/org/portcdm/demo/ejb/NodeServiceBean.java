/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.portcdm.demo.ejb;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import org.portcdm.demo.model.Node;

/**
 *
 * @author Glenn
 */
@Singleton
public class NodeServiceBean {
    
    private static Logger logger = Logger.getLogger("org.portcdm.demo.ejb");
    private HashSet<Node> nodeDB = new HashSet();

    @PostConstruct
    public void initDB() {
        NodeServiceBean.debug("Init node service DB");
        nodeDB.add(new Node("State 1", Node.NodeType.State, NodeServiceBean.getRandomDate()));
        nodeDB.add(new Node("State 2", Node.NodeType.State, NodeServiceBean.getRandomDate()));
        nodeDB.add(new Node("State 3", Node.NodeType.State, NodeServiceBean.getRandomDate()));
        nodeDB.add(new Node("Action 1", Node.NodeType.Action, NodeServiceBean.getRandomDate()));
    }
    
    public HashSet<Node> getNodeDB() {
        return nodeDB;
    }        

    public static void debug(String message) {
        logger.info(message);
    }
    
    protected static Date getRandomDate(){
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(210, 2013);
        gc.set(GregorianCalendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);        
        gc.set(GregorianCalendar.HOUR_OF_DAY, randBetween(1, 24));
        gc.set(GregorianCalendar.MINUTE, randBetween(0, 59));

        return gc.getTime();
    }
    
    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
