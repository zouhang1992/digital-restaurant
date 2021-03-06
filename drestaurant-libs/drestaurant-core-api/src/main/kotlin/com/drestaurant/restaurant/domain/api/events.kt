package com.drestaurant.restaurant.domain.api

import com.drestaurant.common.domain.api.AuditableAbstractEvent
import com.drestaurant.common.domain.api.model.AuditEntry
import com.drestaurant.restaurant.domain.api.model.RestaurantId
import com.drestaurant.restaurant.domain.api.model.RestaurantMenu
import com.drestaurant.restaurant.domain.api.model.RestaurantOrderId
import com.drestaurant.restaurant.domain.api.model.RestaurantOrderLineItem

/**
 * Abstract Restaurant event
 */
abstract class RestaurantEvent(open val aggregateIdentifier: RestaurantId, override val auditEntry: AuditEntry) : AuditableAbstractEvent(auditEntry)

/**
 * Abstract RestaurantOrder event
 */
abstract class RestaurantOrderEvent(open val aggregateIdentifier: RestaurantOrderId, override val auditEntry: AuditEntry) : AuditableAbstractEvent(auditEntry)

/**
 * An event, noting that restaurant has been created
 */
data class RestaurantCreatedEvent(val name: String, val menu: RestaurantMenu, override val aggregateIdentifier: RestaurantId, override val auditEntry: AuditEntry) : RestaurantEvent(aggregateIdentifier, auditEntry)

/**
 * An event, noting that restaurant order has been created
 */
data class RestaurantOrderCreatedEvent(val lineItems: List<RestaurantOrderLineItem>, val restaurantId: RestaurantId, override val aggregateIdentifier: RestaurantOrderId, override val auditEntry: AuditEntry) : RestaurantOrderEvent(aggregateIdentifier, auditEntry)

/**
 * An event, noting that restaurant order has been prepared
 */
data class RestaurantOrderPreparedEvent(override val aggregateIdentifier: RestaurantOrderId, override val auditEntry: AuditEntry) : RestaurantOrderEvent(aggregateIdentifier, auditEntry)

/**
 * An event, noting that restaurant order has been rejected
 */
data class RestaurantOrderRejectedEvent(override val aggregateIdentifier: RestaurantOrderId, override val auditEntry: AuditEntry) : RestaurantOrderEvent(aggregateIdentifier, auditEntry)