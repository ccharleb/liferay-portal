/* global L */

import MarkerBase from 'map-common/js/MarkerBase.es';

/**
 * OpenStreetMapMarker
 */
class OpenStreetMapMarker extends MarkerBase {
	/**
	 * If a marked has been created, sets the marker location to the given one
	 * @param {Object} location Location to set the native marker in
	 */
	setPosition(location) {
		if (this._nativeMarker) {
			this._nativeMarker.setLatLng(location);
		}
	}

	/** @inheritdoc */
	_getNativeMarker(location, map) {
		if (!this._nativeMarker) {
			this._nativeMarker = L.marker(location, {
				draggable: true,
			}).addTo(map);

			this._nativeMarker.on('click', this._getNativeEventFunction('click'));
			this._nativeMarker.on(
				'dblclick',
				this._getNativeEventFunction('dblclick')
			);
			this._nativeMarker.on('drag', this._getNativeEventFunction('drag'));
			this._nativeMarker.on('dragend', this._getNativeEventFunction('dragend'));
			this._nativeMarker.on(
				'dragstart',
				this._getNativeEventFunction('dragstart')
			);
			this._nativeMarker.on(
				'mousedown',
				this._getNativeEventFunction('mousedown')
			);
			this._nativeMarker.on(
				'mouseout',
				this._getNativeEventFunction('mouseout')
			);
			this._nativeMarker.on(
				'mouseover',
				this._getNativeEventFunction('mouseover')
			);
		}

		return this._nativeMarker;
	}

	/** @inheritdoc */
	_getNormalizedEventData(nativeEvent) {
		return {
			location: nativeEvent.target.getLatLng(),
		};
	}
}

export default OpenStreetMapMarker;
