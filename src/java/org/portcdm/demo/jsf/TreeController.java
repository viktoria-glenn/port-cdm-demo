/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.portcdm.demo.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.portcdm.demo.ejb.NodeHandlerBean;
import org.portcdm.demo.ejb.NodeServiceBean;
import org.portcdm.demo.model.Node;
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
    private TreeNode[] currentSelectedNodes;
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

    public TreeNode getCurrentTree() {
        return currentTree;
    }

    public TreeNode[] getCurrentSelectedNodes() {
        return currentSelectedNodes;
    }

    public void setCurrentSelectedNodes(TreeNode[] currentSelectedNodes) {
        this.currentSelectedNodes = currentSelectedNodes;
    }

    public String getControllerName() {
        return controllerName;
    }
}
