/* global Liferay */

import State, {Config} from 'metal-state';

/**
 * MarkerBase
 * Each instance represents a marker being shown in the map.
 * The implemented abstract methods will allow adding markers
 * to the map instance and detecting click events on them.
 * @abstract
 */
class MarkerBase extends State {
	/**
	 * Initializes the instance with a native marker which will handle all
	 * the execution. This function may be moved to the class constructor in
	 * the future, but currently it supports the legacy API.
	 */
	constructor(...args) {
		super(...args);
		this._nativeMarker = this._getNativeMarker(this.location, this.map);
	}

	/**
	 * Parses the given nativeEvent and emits a new event with the given
	 * event type.
	 * @param {Event} nativeEvent Native event that will be parsed.
	 * @param {string} externalEventType Event type that will be emitted.
	 */
	_handleNativeEvent(nativeEvent, externalEventType) {
		this.emit(externalEventType, this._getNormalizedEventData(nativeEvent));
	}

	/**
	 * Generates a function that, when fired, emits an event with a normalized
	 * version of the received event and the given event type.
	 * @param {string} externalEventType Event that will be emited when the
	 * 	function is executed.
	 * @return {function} Generated event handler.
	 */
	_getNativeEventFunction(externalEventType) {
		const functionName = `_nativeEventHandler_${externalEventType}`;

		this[functionName] =
			this[functionName] ||
			(nativeEvent => {
				this._handleNativeEvent(nativeEvent, externalEventType);
			});

		return this[functionName];
	}

	/**
	 * Returns a nativeMarket object for a given location and map.
	 * At this point any extra event should be added to the object, using
	 * the implemented method _handleNativeEvent as handler.
	 * @abstract
	 * @param {Object} location
	 * @param {Object} map
	 * @return {Object} Generated native marker
	 */
	_getNativeMarker(/* location, map */) {
		throw new Error('Must be implemented');
	}

	/**
	 * For a given event, it returns a normalized version of it
	 * with a common structure
	 * @abstract
	 * @param {Event} nativeEvent
	 * @return {{ lat: number, lng: number }}
	 */
	_getNormalizedEventData(/* nativeEvent */) {
		throw new Error('Must be implemented');
	}
}

/**
 * State definition.
 * @type {!Object}
 * @static
 */
MarkerBase.STATE = {
	/**
	 * Map to be used
	 * @type {Object}
	 */
	map: Config.object().value({}),

	/**
	 * Location to be used
	 * @type {Object}
	 */
	location: Config.shapeOf({
		lat: Config.number().required(),
		lng: Config.number().required(),
	}).value({lat: 0, lng: 0}),
};

Liferay.MapMarkerBase = MarkerBase;
export default MarkerBase;
