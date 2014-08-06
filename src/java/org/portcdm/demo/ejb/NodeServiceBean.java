/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.portcdm.demo.ejb;

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
    
    private final static Logger logger = Logger.getLogger("org.portcdm.demo.ejb");
    private HashSet<Node> nodeDB = new HashSet();

    @PostConstruct
    public void initDB() {
        NodeServiceBean.debug("Init node service DB");
    }
    
    public HashSet<Node> getNodeDB() {
        return nodeDB;
    }        

    public static void debug(String message) {
        logger.fine(message);
    }
}
