package com.android.rest.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Entity
@Table(name="hospital", schema ="afia")
public class Hospital {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	@Column(unique = true)
	private String hname;

	private String image;
	
	private String owendby;
	
	private String phoneNumbe;
	
	private String relativeAdress;
	
	private Long latitude;

	private Long longtuide;


	@OneToOne
	@JoinColumn(name ="fx_user")
	private User user;

}
