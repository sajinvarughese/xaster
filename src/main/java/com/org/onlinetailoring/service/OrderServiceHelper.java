package com.org.onlinetailoring.service;

import com.org.onlinetailoring.entity.OrderDetails;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderServiceHelper.
 */
public class OrderServiceHelper {

	/**
	 * Merge order details.
	 *
	 * @param initialOrder
	 *            the initial order
	 * @param updatedOrder
	 *            the updated order
	 * @return the order details
	 */
	public static OrderDetails mergeOrderDetails(OrderDetails initialOrder, OrderDetails updatedOrder) {
		if (!(null == initialOrder.getChest() || initialOrder.getChest().isEmpty())) {
			updatedOrder.setChest(initialOrder.getChest());
		}
		if (!(null == initialOrder.getOrderType() || initialOrder.getOrderType().isEmpty())) {
			updatedOrder.setOrderType(initialOrder.getOrderType());
		}
		if (null != initialOrder.getId()) {
			updatedOrder.setId(initialOrder.getId());
		}
		if (!(null == initialOrder.getNeck() || initialOrder.getNeck().isEmpty())) {
			updatedOrder.setNeck(initialOrder.getNeck());
		}
		if (!(null == initialOrder.getStomach() || initialOrder.getStomach().isEmpty())) {
			updatedOrder.setStomach(initialOrder.getStomach());
		}
		if (!(null == initialOrder.getWaist() || initialOrder.getWaist().isEmpty())) {
			updatedOrder.setWaist(initialOrder.getWaist());
		}
		if (!(null == initialOrder.getShoulder() || initialOrder.getShoulder().isEmpty())) {
			updatedOrder.setShoulder(initialOrder.getShoulder());
		}
		if (!(null == initialOrder.getLength() || initialOrder.getLength().isEmpty())) {
			updatedOrder.setLength(initialOrder.getLength());
		}
		if (!(null == initialOrder.getWrist() || initialOrder.getWrist().isEmpty())) {
			updatedOrder.setWrist(initialOrder.getWrist());
		}
		if (!(null == initialOrder.getVestLength() || initialOrder.getVestLength().isEmpty())) {
			updatedOrder.setVestLength(initialOrder.getVestLength());
		}
		if (!(null == initialOrder.getHips() || initialOrder.getHips().isEmpty())) {
			updatedOrder.setHips(initialOrder.getHips());
		}
		if (!(null == initialOrder.getCrotch() || initialOrder.getCrotch().isEmpty())) {
			updatedOrder.setCrotch(initialOrder.getCrotch());
		}
		if (!(null == initialOrder.getThigh() || initialOrder.getThigh().isEmpty())) {
			updatedOrder.setThigh(initialOrder.getThigh());
		}
		if (!(null == initialOrder.getWidth() || initialOrder.getWidth().isEmpty())) {
			updatedOrder.setWidth(initialOrder.getWidth());
		}
		if (!(null == initialOrder.getInseam() || initialOrder.getInseam().isEmpty())) {
			updatedOrder.setInseam(initialOrder.getInseam());
		}
		if (!(null == initialOrder.getKnee() || initialOrder.getKnee().isEmpty())) {
			updatedOrder.setKnee(initialOrder.getKnee());
		}
		if (!(null == initialOrder.getHalfHem() || initialOrder.getHalfHem().isEmpty())) {
			updatedOrder.setHalfHem(initialOrder.getHalfHem());
		}
		if (!(null == initialOrder.getBust() || initialOrder.getBust().isEmpty())) {
			updatedOrder.setBust(initialOrder.getBust());
		}
		if (!(null == initialOrder.getFrontNeckDepth() || initialOrder.getFrontNeckDepth().isEmpty())) {
			updatedOrder.setFrontNeckDepth(initialOrder.getFrontNeckDepth());
		}
		if (!(null == initialOrder.getBackNeckDepth() || initialOrder.getBackNeckDepth().isEmpty())) {
			updatedOrder.setBackNeckDepth(initialOrder.getBackNeckDepth());
		}
		if (!(null == initialOrder.getSleeveLength() || initialOrder.getSleeveLength().isEmpty())) {
			updatedOrder.setSleeveLength(initialOrder.getSleeveLength());
		}
		if (!(null == initialOrder.getSleeveRound() || initialOrder.getSleeveRound().isEmpty())) {
			updatedOrder.setSleeveRound(initialOrder.getSleeveRound());
		}
		if (!(null == initialOrder.getBottomWidth() || initialOrder.getBottomWidth().isEmpty())) {
			updatedOrder.setBottomWidth(initialOrder.getBottomWidth());
		}
		if (!(null == initialOrder.getSideSlitLength() || initialOrder.getSideSlitLength().isEmpty())) {
			updatedOrder.setSideSlitLength(initialOrder.getSideSlitLength());
		}
		if (!(null == initialOrder.getUpperChest() || initialOrder.getUpperChest().isEmpty())) {
			updatedOrder.setUpperChest(initialOrder.getUpperChest());
		}
		if (!(null == initialOrder.getDressMaterial() || initialOrder.getDressMaterial().isEmpty())) {
			updatedOrder.setDressMaterial(initialOrder.getDressMaterial());
		}
		if (!(null == initialOrder.getFrontNeckDesign() || initialOrder.getFrontNeckDesign().isEmpty())) {
			updatedOrder.setFrontNeckDesign(initialOrder.getFrontNeckDesign());
		}
		if (!(null == initialOrder.getLiningRequired() || initialOrder.getLiningRequired().isEmpty())) {
			updatedOrder.setLiningRequired(initialOrder.getLiningRequired());
		}
		if (!(null == initialOrder.getDescription() || initialOrder.getDescription().isEmpty())) {
			updatedOrder.setDescription(initialOrder.getDescription());
		}
		if (!(null == initialOrder.getFurtherDesign() || initialOrder.getFurtherDesign().isEmpty())) {
			updatedOrder.setFurtherDesign(initialOrder.getFurtherDesign());
		}
		if (!(null == initialOrder.getQuantity() || initialOrder.getQuantity().isEmpty())) {
			updatedOrder.setQuantity(initialOrder.getQuantity());
		}
		if (!(null == initialOrder.getDeliveryDate() || initialOrder.getDeliveryDate().isEmpty())) {
			updatedOrder.setDeliveryDate(initialOrder.getDeliveryDate());
		}
		if (!(null == initialOrder.getOrderDate() || initialOrder.getOrderDate().isEmpty())) {
			updatedOrder.setOrderDate(initialOrder.getOrderDate());
		}

		return updatedOrder;
	}

}
