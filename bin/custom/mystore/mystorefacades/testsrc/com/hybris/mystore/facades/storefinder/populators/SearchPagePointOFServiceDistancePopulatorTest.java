/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.hybris.mystore.facades.storefinder.populators;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.storefinder.data.PointOfServiceDistanceData;
import de.hybris.platform.commerceservices.storefinder.data.StoreFinderSearchPageData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Unit test for {@link SearchPagePointOfServiceDistancePopulator}.
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SearchPagePointOFServiceDistancePopulatorTest
{
	@Mock
	private PointOfServiceData pointOfServiceData;
	@Mock
	Converter<PointOfServiceDistanceData, PointOfServiceData> pointOfServiceDistanceConverter;
	@Mock
	private PointOfServiceDistanceData pointOfServiceDistanceData;
	@Mock
	private PaginationData paginationData;
	@InjectMocks
	private SearchPagePointOfServiceDistancePopulator searchPagePointOfServiceDistancePopulator;

	@Test
	public void testPopulate()
	{
		StoreFinderSearchPageData<PointOfServiceDistanceData> src = mock(StoreFinderSearchPageData.class);
		final  StoreFinderSearchPageData<PointOfServiceData> target = mock(StoreFinderSearchPageData.class);
		List list=new ArrayList<>();
		List<PointOfServiceDistanceData> list1=new ArrayList<>();
		list1.add(pointOfServiceDistanceData);
		list.add(pointOfServiceData);
		when(pointOfServiceData.getName()).thenReturn("name");
		when(target.getResults()).thenReturn(list);
		when(target.getSourceLatitude()).thenReturn(123.3);
		when(target.getSourceLongitude()).thenReturn(123.3);
		when(src.getPagination()).thenReturn(paginationData);
		when(src.getSorts()).thenReturn(new ArrayList<>());
		when(src.getLocationText()).thenReturn("location");
		when(src.getSourceLatitude()).thenReturn(123.3);
		when(src.getSourceLongitude()).thenReturn(123.3);
		when(src.getResults()).thenReturn(list1);

		when(src.getBoundNorthLatitude()).thenReturn(1233.3);
		when(src.getBoundSouthLatitude()).thenReturn(12.3);
		when(src.getBoundWestLongitude()).thenReturn(45.4);
		when(src.getBoundEastLongitude()).thenReturn(34.4);

		searchPagePointOfServiceDistancePopulator.populate(src,target);
		Assert.assertEquals("name", target.getResults().get(0).getName() );
	}

	@Test
	public void testPopulate1()
	{
		StoreFinderSearchPageData<PointOfServiceDistanceData> src = mock(StoreFinderSearchPageData.class);
		final  StoreFinderSearchPageData<PointOfServiceData> target = mock(StoreFinderSearchPageData.class);
		List list=new ArrayList<>();
		List<PointOfServiceDistanceData> lis1=new ArrayList<>();
		lis1.add(pointOfServiceDistanceData);
		list.add(pointOfServiceData);
		when(pointOfServiceData.getName()).thenReturn("name");
		when(target.getLocationText()).thenReturn("location");
		when(target.getResults()).thenReturn(list);
		when(target.getSourceLatitude()).thenReturn(123.3);
		when(target.getSourceLongitude()).thenReturn(123.3);
		when(src.getPagination()).thenReturn(paginationData);
		when(src.getSorts()).thenReturn(new ArrayList<>());
		when(src.getLocationText()).thenReturn("location");
		when(src.getSourceLatitude()).thenReturn(123.3);
		when(src.getSourceLongitude()).thenReturn(123.3);
		when(src.getResults()).thenReturn(lis1);

		when(src.getBoundNorthLatitude()).thenReturn(1233.3);
		when(src.getBoundSouthLatitude()).thenReturn(12.3);
		when(src.getBoundWestLongitude()).thenReturn(45.4);
		when(src.getBoundEastLongitude()).thenReturn(34.4);

		searchPagePointOfServiceDistancePopulator.populate(src,target);
		Assert.assertEquals("name", target.getResults().get(0).getName());
	}
}
