package BranchManager;

import java.io.Serializable;
import java.util.ArrayList;

import common.Branch;

public class SpecialBranchesMessage implements Serializable
{
	private ArrayList<Branch> allBranches = new ArrayList<Branch>();
	private ArrayList<BranchManager> allBranchManagers= new ArrayList<BranchManager>();
	public SpecialBranchesMessage() 
	{
	
	}
	public ArrayList<Branch> getAllBranches() 
	{
		return allBranches;
	}
	public void setAllBranches(ArrayList<Branch> allBranches) 
	{
		this.allBranches = allBranches;
	}
	public ArrayList<BranchManager> getAllBranchManagers() 
	{
		return allBranchManagers;
	}
	public void setAllBranchManagers(ArrayList<BranchManager> allBranchManagers) 
	{
		this.allBranchManagers = allBranchManagers;
	}
	
	
	
	
}


