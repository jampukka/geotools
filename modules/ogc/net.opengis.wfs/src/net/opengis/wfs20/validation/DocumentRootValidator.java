/**
 *
 * $Id$
 */
package net.opengis.wfs20.validation;

import net.opengis.wfs20.AbstractTransactionActionType;
import net.opengis.wfs20.AbstractType;
import net.opengis.wfs20.AdditionalObjectsType;
import net.opengis.wfs20.AdditionalValuesType;
import net.opengis.wfs20.CreateStoredQueryResponseType;
import net.opengis.wfs20.CreateStoredQueryType;
import net.opengis.wfs20.DeleteType;
import net.opengis.wfs20.DescribeFeatureTypeType;
import net.opengis.wfs20.DescribeStoredQueriesResponseType;
import net.opengis.wfs20.DescribeStoredQueriesType;
import net.opengis.wfs20.DropStoredQueryType;
import net.opengis.wfs20.ElementType;
import net.opengis.wfs20.EnvelopePropertyType;
import net.opengis.wfs20.ExecutionStatusType;
import net.opengis.wfs20.FeatureCollectionType;
import net.opengis.wfs20.FeatureTypeListType;
import net.opengis.wfs20.GetCapabilitiesType;
import net.opengis.wfs20.GetFeatureType;
import net.opengis.wfs20.GetFeatureWithLockType;
import net.opengis.wfs20.GetPropertyValueType;
import net.opengis.wfs20.InsertType;
import net.opengis.wfs20.ListStoredQueriesResponseType;
import net.opengis.wfs20.ListStoredQueriesType;
import net.opengis.wfs20.LockFeatureResponseType;
import net.opengis.wfs20.LockFeatureType;
import net.opengis.wfs20.MemberPropertyType;
import net.opengis.wfs20.NativeType;
import net.opengis.wfs20.PropertyNameType;
import net.opengis.wfs20.PropertyType;
import net.opengis.wfs20.QueryType;
import net.opengis.wfs20.ReplaceType;
import net.opengis.wfs20.SimpleFeatureCollectionType;
import net.opengis.wfs20.StoredQueryType;
import net.opengis.wfs20.TitleType;
import net.opengis.wfs20.TransactionResponseType;
import net.opengis.wfs20.TransactionType;
import net.opengis.wfs20.TruncatedResponseType;
import net.opengis.wfs20.TupleType;
import net.opengis.wfs20.UpdateType;
import net.opengis.wfs20.ValueCollectionType;
import net.opengis.wfs20.ValueListType;
import net.opengis.wfs20.WFSCapabilitiesType;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * A sample validator interface for {@link net.opengis.wfs20.DocumentRoot}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DocumentRootValidator {
  boolean validate();

  boolean validateMixed(FeatureMap value);
  boolean validateXMLNSPrefixMap(EMap<String, String> value);
  boolean validateXSISchemaLocation(EMap<String, String> value);
  boolean validateAbstract(AbstractType value);
  boolean validateAbstractTransactionAction(AbstractTransactionActionType value);
  boolean validateAdditionalObjects(AdditionalObjectsType value);
  boolean validateAdditionalValues(AdditionalValuesType value);
  boolean validateBoundedBy(EnvelopePropertyType value);
  boolean validateCreateStoredQuery(CreateStoredQueryType value);
  boolean validateCreateStoredQueryResponse(CreateStoredQueryResponseType value);
  boolean validateDelete(DeleteType value);
  boolean validateDescribeFeatureType(DescribeFeatureTypeType value);
  boolean validateDescribeStoredQueries(DescribeStoredQueriesType value);
  boolean validateDescribeStoredQueriesResponse(DescribeStoredQueriesResponseType value);
  boolean validateDropStoredQuery(DropStoredQueryType value);
  boolean validateDropStoredQueryResponse(ExecutionStatusType value);
  boolean validateElement(ElementType value);
  boolean validateFeatureCollection(FeatureCollectionType value);
  boolean validateSimpleFeatureCollection(SimpleFeatureCollectionType value);
  boolean validateFeatureTypeList(FeatureTypeListType value);
  boolean validateGetCapabilities(GetCapabilitiesType value);
  boolean validateGetFeature(GetFeatureType value);
  boolean validateGetFeatureWithLock(GetFeatureWithLockType value);
  boolean validateGetPropertyValue(GetPropertyValueType value);
  boolean validateInsert(InsertType value);
  boolean validateListStoredQueries(ListStoredQueriesType value);
  boolean validateListStoredQueriesResponse(ListStoredQueriesResponseType value);
  boolean validateLockFeature(LockFeatureType value);
  boolean validateLockFeatureResponse(LockFeatureResponseType value);
  boolean validateMember(MemberPropertyType value);
  boolean validateNative(NativeType value);
  boolean validateProperty(PropertyType value);
  boolean validatePropertyName(PropertyNameType value);
  boolean validateQuery(QueryType value);
  boolean validateReplace(ReplaceType value);
  boolean validateStoredQuery(StoredQueryType value);
  boolean validateTitle(TitleType value);
  boolean validateTransaction(TransactionType value);
  boolean validateTransactionResponse(TransactionResponseType value);
  boolean validateTruncatedResponse(TruncatedResponseType value);
  boolean validateTuple(TupleType value);
  boolean validateUpdate(UpdateType value);
  boolean validateValue(EObject value);
  boolean validateValueCollection(ValueCollectionType value);
  boolean validateValueList(ValueListType value);
  boolean validateWFSCapabilities(WFSCapabilitiesType value);
}
