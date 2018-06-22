package com.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_EQVMDETAILS", query = "from EQVMDetails") })
public class EQVMDetails {

	@TableGenerator(name = "Vm_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Vm_Gen", initialValue = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Vm_Gen")
	@Column(name = "VM_ID")
	private long VmId;

	private String hostName;

	private String ip;

	public EQVMDetails(String hostName, String ip) {
		this.hostName = hostName;
		this.ip = ip;
	}

	public EQVMDetails() {
	}

}
