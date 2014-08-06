/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.portcdm.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Glenn
 */
public class Node implements Serializable, Comparable<Node>{
    
    private UUID nodeId;
    private String nodeName;
    private String nodeType;
    private Date created;
    private Date completed;

    public Node(String nodeName, String nodeType, Date created) {
        this.nodeId = UUID.randomUUID();
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.created = created;
    }

    public UUID getNodeId() {
        return nodeId;
    }   

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }
    
    
    
    @Override
    public int compareTo(Node o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
