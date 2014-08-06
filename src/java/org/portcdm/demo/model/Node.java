/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.portcdm.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Glenn
 */
public class Node implements Serializable, Comparable<Node>{
    
    public enum NodeType {
        State,
        Action
    }
    
    private UUID nodeId;
    private String  nodeName;
    private NodeType nodeType;
    private Date created;
    private Date completed;

    public Node(String nodeName, NodeType nodeType, Date created) {
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

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
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
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nodeId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.nodeId, other.nodeId)) {
            return false;
        }
        return true;
    }        
    
    @Override
    public int compareTo(Node o) {
        return this.nodeId.compareTo(o.getNodeId());
    }
    
}
