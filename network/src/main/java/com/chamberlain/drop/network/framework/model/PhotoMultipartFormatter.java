/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.chamberlain.drop.network.framework.di.ServicesModule.PHOTO_PART_NAME;

public class PhotoMultipartFormatter {

    private static final String JPEG_PART_CONTENT_TYPE = "image/jpeg";

    private final String partName;

    @Inject
    public PhotoMultipartFormatter(@Named(PHOTO_PART_NAME) String partName) {
        this.partName = partName;
    }

    public MultipartBody.Part formatAsJpeg(File photo) {
        RequestBody requestPhoto = RequestBody.create(MediaType.parse(JPEG_PART_CONTENT_TYPE), compressJpegForUpload(photo));
        return MultipartBody.Part.createFormData(partName, photo.getName(), requestPhoto);
    }

    private byte[] compressJpegForUpload(File photo) {
        Bitmap bmp = BitmapFactory.decodeFile(photo.getAbsolutePath());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 75, output);

        return output.toByteArray();
    }
}
