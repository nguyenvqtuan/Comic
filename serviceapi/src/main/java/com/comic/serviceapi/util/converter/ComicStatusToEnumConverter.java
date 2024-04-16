package com.comic.serviceapi.util.converter;

import org.modelmapper.AbstractConverter;

import com.comic.serviceapi.util.ComicStatus;

public class ComicStatusToEnumConverter extends AbstractConverter<Byte, String>{

	@Override
	protected String convert(Byte source) {
		return ComicStatus.values()[source].toString();
	}
}
