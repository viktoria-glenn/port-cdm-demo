/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.portcdm.demo.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.portcdm.demo.ejb.NodeHandlerBean;
import org.portcdm.demo.ejb.NodeServiceBean;
import org.portcdm.demo.model.Node;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Glenn
 */
@Named("treeController")
@ViewScoped
public class TreeController implements Serializable {

    @EJB
    protected NodeHandlerBean nodeHandler;
    private TreeNode currentTree;
    private DefaultTreeNode currentSelectedNodes;
    private String controllerName = "treeController";

    public TreeController() {
        NodeServiceBean.debug("Mest skit");
    }

    public void buildTreeNode() {
        List<Node> nodeList = nodeHandler.retrieveCurrentTreeNodes();
        if (nodeList == null) {
            JsfUtil.addErrorMessage("Node node persisted");
            return;
        }
        currentTree = new DefaultTreeNode("root", null);
        recursiveTreeBuilder(currentTree, nodeList);
    }
    
    private void recursiveTreeBuilder(TreeNode parentTreeNode, List<Node>  childTreeNodeList) {
        for(Node node : childTreeNodeList){
            DefaultTreeNode treeNode = new DefaultTreeNode(node.getNodeType().toString(), node.getNodeName(), parentTreeNode);
            if(!node.getChildNodes().isEmpty()) {
                this.recursiveTreeBuilder(treeNode, node.getChildNodes());
            }
        }        
    }

    public void onNodeSelect(NodeSelectEvent event){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected ", event.getTreeNode().toString());
         FacesContext.getCurrentInstance().addMessage(controllerName, message);
    }
    public TreeNode getCurrentTree() {
        return currentTree;
    }

    public DefaultTreeNode getCurrentSelectedNodes() {
        return currentSelectedNodes;
    }

    public void setCurrentSelectedNodes(DefaultTreeNode currentSelectedNodes) {
        this.currentSelectedNodes = currentSelectedNodes;
    }

    public String getControllerName() {
        return controllerName;
    }
}
