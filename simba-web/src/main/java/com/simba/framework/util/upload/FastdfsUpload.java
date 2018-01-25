package com.simba.framework.util.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.common.FastdfsException;

import com.simba.fastdfs.FastdfsUtil;
import com.simba.framework.util.common.SystemUtil;
import com.simba.model.constant.ConstantData;

/**
 * fastdfs分布式文件上传管理
 * 
 * @author caozhejun
 *
 */
public class FastdfsUpload implements UploadInterface {

	private static final Log logger = LogFactory.getLog(FastdfsUpload.class);

	private FastdfsUpload() {

	}

	private static final class FastdfsUploadHolder {
		private static final FastdfsUpload instance = new FastdfsUpload();
	}

	public static FastdfsUpload getInstance() {
		return FastdfsUploadHolder.instance;
	}

	private String dealPath(String path) {
		try {
			return "/download/download.do?fileName=" + URLEncoder.encode(path, ConstantData.DEFAULT_CHARSET);
		} catch (UnsupportedEncodingException e) {
			logger.error("处理路径URI编码异常" + path, e);
			return path;
		}
	}

	@Override
	public String upload(byte[] content, String fileName, String type) throws IOException, FastdfsException {
		return dealPath(FastdfsUtil.getInstance().upload(content, fileName));
	}

	@Override
	public String upload(byte[] content, String fileName) throws IOException, FastdfsException {
		return upload(content, fileName, StringUtils.EMPTY);
	}

	@Override
	public InputStream download(String fileName) throws IOException, FastdfsException {
		String[] fastdfsFlag = FastdfsUtil.getInstance().parseUrl(fileName);
		String localPath = SystemUtil.getTempDir() + "/" + fastdfsFlag[1];
		FastdfsUtil.getInstance().download(fastdfsFlag[0], fastdfsFlag[1], localPath);
		return new FileInputStream(new File(localPath));
	}

	@Override
	public void delete(String fileName) throws IOException, FastdfsException {
		String[] fastdfsFlag = FastdfsUtil.getInstance().parseUrl(fileName);
		FastdfsUtil.getInstance().delete(fastdfsFlag[0], fastdfsFlag[1]);
	}

	@Override
	public long size(String fileName) throws IOException, FastdfsException {
		String[] fastdfsFlag = FastdfsUtil.getInstance().parseUrl(fileName);
		return FastdfsUtil.getInstance().size(fastdfsFlag[0], fastdfsFlag[1]);
	}

}
