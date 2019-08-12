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
package com.hybris.mystore.facades.populators;

import com.hybris.mystore.core.model.ApparelProductModel;
import com.hybris.mystore.facades.product.data.GenderData;
import com.hybris.mystore.facades.storefinder.populators.SearchPagePointOfServiceDistancePopulator;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.enums.Gender;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.variants.model.VariantProductModel;
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
public class ApparelProductPopulatorTest
{
	@Mock
	Converter<Gender, GenderData> genderConverter;
	@Mock
	private ApparelProductModel productModel;
	@InjectMocks
	private


	apparelProductPopulator;

	@Test
	public void testPopulate()
	{
		List<Gender> list=new ArrayList<>();
		list.add(Gender.FEMALE);
		VariantProductModel src=mock(VariantProductModel.class);
		ProductData target = mock(ProductData.class);
		when(src.getBaseProduct()).thenReturn(productModel);
		when(productModel.getGenders()).thenReturn(list);
		apparelProductPopulator.populate(src,target);
		Assert.assertNotNull( target.getGenders());
	}
}
