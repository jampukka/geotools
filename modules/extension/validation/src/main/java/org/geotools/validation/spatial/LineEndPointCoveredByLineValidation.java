/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2004-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.validation.spatial;

import java.util.Map;
import org.geotools.data.collection.ListFeatureCollection;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.validation.ValidationResults;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;

/**
 * PointCoveredByLineValidation purpose.
 *
 * <p>Checks to ensure the Line End Point is covered by the Line.
 *
 * @author dzwiers, Refractions Research, Inc.
 * @author $Author: dmzwiers $ (last modification)
 * @version $Id$
 */
public class LineEndPointCoveredByLineValidation extends LineLineAbstractValidation {
    /**
     * PointCoveredByLineValidation constructor.
     *
     * <p>Super
     */
    public LineEndPointCoveredByLineValidation() {
        super();
    }

    /**
     * Ensure Line End Point is covered by the Line.
     *
     * <p>
     *
     * @param layers a HashMap of key="TypeName" value="FeatureSource"
     * @param envelope The bounding box of modified features
     * @param results Storage for the error and warning messages
     * @return True if no features intersect. If they do then the validation failed.
     * @see org.geotools.validation.IntegrityValidation#validate(java.util.Map,
     *     org.locationtech.jts.geom.Envelope, org.geotools.validation.ValidationResults)
     */
    public boolean validate(Map layers, Envelope envelope, ValidationResults results)
            throws Exception {

        boolean r = true;

        SimpleFeatureSource fsLine = (SimpleFeatureSource) layers.get(getLineTypeRef());

        SimpleFeatureCollection fcLine = fsLine.getFeatures();
        try (SimpleFeatureIterator fLine = fcLine.features()) {

            SimpleFeatureSource fsRLine =
                    (SimpleFeatureSource) layers.get(getRestrictedLineTypeRef());

            ListFeatureCollection fcRLine = new ListFeatureCollection(fsRLine.getFeatures());

            while (fLine.hasNext()) {
                SimpleFeature line = fLine.next();
                try (SimpleFeatureIterator fRLine = fcRLine.features()) {
                    Geometry lineGeom = (Geometry) line.getDefaultGeometry();
                    if (envelope.contains(lineGeom.getEnvelopeInternal())) {
                        // 	check for valid comparison
                        if (LineString.class.isAssignableFrom(lineGeom.getClass())) {
                            while (fRLine.hasNext()) {
                                SimpleFeature rLine = fRLine.next();
                                Geometry rLineGeom = (Geometry) rLine.getDefaultGeometry();
                                if (envelope.contains(rLineGeom.getEnvelopeInternal())) {
                                    if (LineString.class.isAssignableFrom(rLineGeom.getClass())) {
                                        Point p1 = ((LineString) rLineGeom).getEndPoint();
                                        // Point p2 = ((LineString)rLineGeom).getStartPoint();
                                        // //include
                                        // this?
                                        if (!lineGeom.contains(p1)) {
                                            // if(!(lineGeom.contains(p1) ||
                                            // lineGeom.contains(p2))){
                                            results.error(
                                                    rLine,
                                                    "Line End Point not covered by the specified Line.");
                                            r = false;
                                        }
                                        // do next.
                                    } else {
                                        fcRLine.remove(rLine);
                                        results.warning(
                                                rLine,
                                                "Invalid type: this feature is not a derivative of a LineString");
                                    }
                                } else {
                                    fcRLine.remove(rLine);
                                }
                            }
                        } else {
                            results.warning(
                                    line,
                                    "Invalid type: this feature is not a derivative of a LineString");
                        }
                    }
                }
            }
        }
        return r;
    }
}
