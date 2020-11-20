package com.org.onlinetailoring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderDetails.
 */
@Entity
public class OrderDetails {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;

	/** The order type. */
	String orderType;
	
	/** The neck. */
	String neck;
	
	/** The chest. */
	String chest;
	
	/** The stomach. */
	String stomach;
	
	/** The waist. */
	String waist;
	
	/** The shoulder. */
	String shoulder;
	
	/** The length. */
	String length;
	
	/** The wrist. */
	String wrist;
	
	/** The vest length. */
	String vestLength;
	
	/** The hips. */
	String hips;
	
	/** The crotch. */
	String crotch;
	
	/** The thigh. */
	String thigh;
	
	/** The width. */
	String width;
	
	/** The inseam. */
	String inseam;
	
	/** The knee. */
	String knee;
	
	/** The half hem. */
	String halfHem;
	
	/** The bust. */
	String bust;
	
	/** The front neck depth. */
	String frontNeckDepth;
	
	/** The back neck depth. */
	String backNeckDepth;
	
	/** The sleeve length. */
	String sleeveLength;
	
	/** The sleeve round. */
	String sleeveRound;
	
	/** The bottom width. */
	String bottomWidth;
	
	/** The side slit length. */
	String sideSlitLength;
	
	/** The upper chest. */
	String upperChest;
	
	/** The dress material. */
	String dressMaterial;
	
	/** The front neck design. */
	String frontNeckDesign;
	
	/** The lining required. */
	String liningRequired;
	
	/** The description. */
	String description;
	
	/** The further design. */
	String furtherDesign;
	
	/** The quantity. */
	String quantity;
	
	/** The delivery date. */
	String deliveryDate;
	
	/** The order date. */
	String orderDate;
	
	/** The user details. */
	@ManyToOne
	@JoinColumn(name = "user_id")
	UserDetails userDetails;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the order type.
	 *
	 * @return the order type
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * Sets the order type.
	 *
	 * @param orderType the new order type
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * Gets the neck.
	 *
	 * @return the neck
	 */
	public String getNeck() {
		return neck;
	}

	/**
	 * Sets the neck.
	 *
	 * @param neck the new neck
	 */
	public void setNeck(String neck) {
		this.neck = neck;
	}

	/**
	 * Gets the chest.
	 *
	 * @return the chest
	 */
	public String getChest() {
		return chest;
	}

	/**
	 * Sets the chest.
	 *
	 * @param chest the new chest
	 */
	public void setChest(String chest) {
		this.chest = chest;
	}

	/**
	 * Gets the stomach.
	 *
	 * @return the stomach
	 */
	public String getStomach() {
		return stomach;
	}

	/**
	 * Sets the stomach.
	 *
	 * @param stomach the new stomach
	 */
	public void setStomach(String stomach) {
		this.stomach = stomach;
	}

	/**
	 * Gets the waist.
	 *
	 * @return the waist
	 */
	public String getWaist() {
		return waist;
	}

	/**
	 * Sets the waist.
	 *
	 * @param waist the new waist
	 */
	public void setWaist(String waist) {
		this.waist = waist;
	}

	/**
	 * Gets the shoulder.
	 *
	 * @return the shoulder
	 */
	public String getShoulder() {
		return shoulder;
	}

	/**
	 * Sets the shoulder.
	 *
	 * @param shoulder the new shoulder
	 */
	public void setShoulder(String shoulder) {
		this.shoulder = shoulder;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public String getLength() {
		return length;
	}

	/**
	 * Sets the length.
	 *
	 * @param length the new length
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * Gets the wrist.
	 *
	 * @return the wrist
	 */
	public String getWrist() {
		return wrist;
	}

	/**
	 * Sets the wrist.
	 *
	 * @param wrist the new wrist
	 */
	public void setWrist(String wrist) {
		this.wrist = wrist;
	}

	/**
	 * Gets the vest length.
	 *
	 * @return the vest length
	 */
	public String getVestLength() {
		return vestLength;
	}

	/**
	 * Sets the vest length.
	 *
	 * @param vestLength the new vest length
	 */
	public void setVestLength(String vestLength) {
		this.vestLength = vestLength;
	}

	/**
	 * Gets the hips.
	 *
	 * @return the hips
	 */
	public String getHips() {
		return hips;
	}

	/**
	 * Sets the hips.
	 *
	 * @param hips the new hips
	 */
	public void setHips(String hips) {
		this.hips = hips;
	}

	/**
	 * Gets the crotch.
	 *
	 * @return the crotch
	 */
	public String getCrotch() {
		return crotch;
	}

	/**
	 * Sets the crotch.
	 *
	 * @param crotch the new crotch
	 */
	public void setCrotch(String crotch) {
		this.crotch = crotch;
	}

	/**
	 * Gets the thigh.
	 *
	 * @return the thigh
	 */
	public String getThigh() {
		return thigh;
	}

	/**
	 * Sets the thigh.
	 *
	 * @param thigh the new thigh
	 */
	public void setThigh(String thigh) {
		this.thigh = thigh;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * Gets the inseam.
	 *
	 * @return the inseam
	 */
	public String getInseam() {
		return inseam;
	}

	/**
	 * Sets the inseam.
	 *
	 * @param inseam the new inseam
	 */
	public void setInseam(String inseam) {
		this.inseam = inseam;
	}

	/**
	 * Gets the knee.
	 *
	 * @return the knee
	 */
	public String getKnee() {
		return knee;
	}

	/**
	 * Sets the knee.
	 *
	 * @param knee the new knee
	 */
	public void setKnee(String knee) {
		this.knee = knee;
	}

	/**
	 * Gets the half hem.
	 *
	 * @return the half hem
	 */
	public String getHalfHem() {
		return halfHem;
	}

	/**
	 * Sets the half hem.
	 *
	 * @param halfHem the new half hem
	 */
	public void setHalfHem(String halfHem) {
		this.halfHem = halfHem;
	}

	/**
	 * Gets the bust.
	 *
	 * @return the bust
	 */
	public String getBust() {
		return bust;
	}

	/**
	 * Sets the bust.
	 *
	 * @param bust the new bust
	 */
	public void setBust(String bust) {
		this.bust = bust;
	}

	/**
	 * Gets the front neck depth.
	 *
	 * @return the front neck depth
	 */
	public String getFrontNeckDepth() {
		return frontNeckDepth;
	}

	/**
	 * Sets the front neck depth.
	 *
	 * @param frontNeckDepth the new front neck depth
	 */
	public void setFrontNeckDepth(String frontNeckDepth) {
		this.frontNeckDepth = frontNeckDepth;
	}

	/**
	 * Gets the back neck depth.
	 *
	 * @return the back neck depth
	 */
	public String getBackNeckDepth() {
		return backNeckDepth;
	}

	/**
	 * Sets the back neck depth.
	 *
	 * @param backNeckDepth the new back neck depth
	 */
	public void setBackNeckDepth(String backNeckDepth) {
		this.backNeckDepth = backNeckDepth;
	}

	/**
	 * Gets the sleeve length.
	 *
	 * @return the sleeve length
	 */
	public String getSleeveLength() {
		return sleeveLength;
	}

	/**
	 * Sets the sleeve length.
	 *
	 * @param sleeveLength the new sleeve length
	 */
	public void setSleeveLength(String sleeveLength) {
		this.sleeveLength = sleeveLength;
	}

	/**
	 * Gets the sleeve round.
	 *
	 * @return the sleeve round
	 */
	public String getSleeveRound() {
		return sleeveRound;
	}

	/**
	 * Sets the sleeve round.
	 *
	 * @param sleeveRound the new sleeve round
	 */
	public void setSleeveRound(String sleeveRound) {
		this.sleeveRound = sleeveRound;
	}

	/**
	 * Gets the bottom width.
	 *
	 * @return the bottom width
	 */
	public String getBottomWidth() {
		return bottomWidth;
	}

	/**
	 * Sets the bottom width.
	 *
	 * @param bottomWidth the new bottom width
	 */
	public void setBottomWidth(String bottomWidth) {
		this.bottomWidth = bottomWidth;
	}

	/**
	 * Gets the side slit length.
	 *
	 * @return the side slit length
	 */
	public String getSideSlitLength() {
		return sideSlitLength;
	}

	/**
	 * Sets the side slit length.
	 *
	 * @param sideSlitLength the new side slit length
	 */
	public void setSideSlitLength(String sideSlitLength) {
		this.sideSlitLength = sideSlitLength;
	}

	/**
	 * Gets the upper chest.
	 *
	 * @return the upper chest
	 */
	public String getUpperChest() {
		return upperChest;
	}

	/**
	 * Sets the upper chest.
	 *
	 * @param upperChest the new upper chest
	 */
	public void setUpperChest(String upperChest) {
		this.upperChest = upperChest;
	}

	/**
	 * Gets the dress material.
	 *
	 * @return the dress material
	 */
	public String getDressMaterial() {
		return dressMaterial;
	}

	/**
	 * Sets the dress material.
	 *
	 * @param dressMaterial the new dress material
	 */
	public void setDressMaterial(String dressMaterial) {
		this.dressMaterial = dressMaterial;
	}

	/**
	 * Gets the front neck design.
	 *
	 * @return the front neck design
	 */
	public String getFrontNeckDesign() {
		return frontNeckDesign;
	}

	/**
	 * Sets the front neck design.
	 *
	 * @param frontNeckDesign the new front neck design
	 */
	public void setFrontNeckDesign(String frontNeckDesign) {
		this.frontNeckDesign = frontNeckDesign;
	}

	/**
	 * Gets the lining required.
	 *
	 * @return the lining required
	 */
	public String getLiningRequired() {
		return liningRequired;
	}

	/**
	 * Sets the lining required.
	 *
	 * @param liningRequired the new lining required
	 */
	public void setLiningRequired(String liningRequired) {
		this.liningRequired = liningRequired;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the further design.
	 *
	 * @return the further design
	 */
	public String getFurtherDesign() {
		return furtherDesign;
	}

	/**
	 * Sets the further design.
	 *
	 * @param furtherDesign the new further design
	 */
	public void setFurtherDesign(String furtherDesign) {
		this.furtherDesign = furtherDesign;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the delivery date.
	 *
	 * @return the delivery date
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * Sets the delivery date.
	 *
	 * @param deliveryDate the new delivery date
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the order date
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the new order date
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets the user details.
	 *
	 * @return the user details
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the user details.
	 *
	 * @param userDetails the new user details
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	
	
}
