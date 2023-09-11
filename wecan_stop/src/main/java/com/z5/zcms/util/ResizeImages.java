package com.z5.zcms.util;

import egovframework.com.cmm.service.EgovProperties;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ResizeImages {

	/* + pom.xml
	 *
	 * <dependency>
			<groupId>net.coobird</groupId>
			<artifactId>thumbnailator</artifactId>
			<version>0.4.5</version>
		</dependency>
	 */

	private String org_path		= EgovProperties.getPathProperty("Globals.archive.image.org");
	private String thbnail_path	= EgovProperties.getPathProperty("Globals.archive.image.thumbnail");
	private String detail_path	= EgovProperties.getPathProperty("Globals.archive.image.detail");
	private String watermark	= EgovProperties.getProperty("Globals.archive.image.watermark");

	private int thbnail_x		= Integer.valueOf(EgovProperties.getProperty("Globals.archive.image.thumbnail_x"));
	private int thbnail_y 		= Integer.valueOf(EgovProperties.getProperty("Globals.archive.image.thumbnail_y"));

	private int detail_x 		= Integer.valueOf(EgovProperties.getProperty("Globals.archive.image.detail_x"));
	private int detail_y 		= Integer.valueOf(EgovProperties.getProperty("Globals.archive.image.detail_y"));

	public int makeThbnail(String src, String tgt) {
		try {
			Thumbnails.of(this.org_path + src)
			.size(this.thbnail_x, this.thbnail_y)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(this.org_path + this.watermark)), 1.0f)
			.toFile(this.thbnail_path + tgt);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int makeDetail(String src, String tgt) {
		try {
			Thumbnails.of(this.org_path + src)
			.size(this.detail_x, this.detail_y)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(this.org_path + this.watermark)), 1.0f)
			.toFile(this.detail_path + tgt);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
