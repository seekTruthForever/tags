package com.whv.flexpaper.tags;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.tagext.BodyTagSupport;

import com.whv.flexpaper.utils.MapStrUtil;
import com.whv.flexpaper.utils.ResponseUtils;


/**
 * FlexPaper标签
 * @author huawei
 *
 */
public class FlexPaper extends BodyTagSupport {
	@Override
	public int doStartTag() throws javax.servlet.jsp.JspException
	{
		rend();
		return super.doStartTag();
	};

	@Override
	public int doEndTag() throws javax.servlet.jsp.JspException
	{
		release();
		return super.doEndTag();
	};

	@Override
	public int doAfterBody() throws javax.servlet.jsp.JspException
	{
		
		return super.doAfterBody();
	};

	@Override
	public void release()
	{
		clearData();
		super.release();
	}
	private void rend() {
		StringBuffer results = new StringBuffer();
		results.append(" <a id=\""+getElementId()+"\" style=\""+getStyle()+"\"></a>");
		results.append("<script type=\"text/javascript\">\n");
		results.append("var fpview = new FlexPaperViewerEmbedding(\"")
			.append(getElementId())
			.append("\",{\"config\":{").append(getConfig()).append("}});");
		results.append("</script>\n");
		ResponseUtils.write(pageContext, results.toString());
		
	}
	private static final long serialVersionUID = -2113952585050207387L;
	private String conf;
	private String style;
	public String getConf() {
		return conf;
	}
	public void setConf(String conf) {
		this.conf = conf;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	private String elementId;
	private String swfFile;
	private String pdfFile;
	private String imgFiles;
	private String jsonFile;
	private String useCustomJSONFormat;
	private String jsonPageDataFormat;
	private String jsonDataType;
	private Double scale;
	private String zoomTransition;
	private Double zoomTime;
	private Double zoomInterval;
	private Boolean fitPageOnLoad;
	private Boolean fitWidthOnLoad;
	private Boolean fullScreenAsMaxWindow;
	private Boolean progressiveLoading;
	private Double minZoomSize;
	private Double maxZoomSize;
	private Boolean searchMatchAll;
	private String searchServiceUrl;
	private String initViewMode;
	private Boolean bitmapBasedRendering;
	private Integer startAtPage;
	private Boolean printPaperAsBitmap;
	private Boolean autoAdjustPrintSize;
	private Boolean enableCornerDragging;
	private String backgroundColor;
	private String panelColor;
	private String backgroundAlpha;
	private String uiConfig;
	private Boolean viewModeToolsVisible;
	private Boolean zoomToolsVisible;
	private Boolean navToolsVisible;
	private Boolean cursorToolsVisible;
	private Boolean searchToolsVisible;
	private String stickyTools;
	private String toolbar;
	private String docSizeQueryService;

	private String renderingOrder;

	private String localeChain;
	private String jsDirectory;
	private String cssDirectory;
	private String localeDirectory;
	private String key;
	public String getUseCustomJSONFormat() {
		return useCustomJSONFormat;
	}
	public void setUseCustomJSONFormat(String useCustomJSONFormat) {
		this.useCustomJSONFormat = useCustomJSONFormat;
	}
	public String getLocaleChain() {
		return localeChain;
	}
	public void setLocaleChain(String localeChain) {
		this.localeChain = localeChain;
	}
	public String getJsDirectory() {
		return jsDirectory;
	}
	public void setJsDirectory(String jsDirectory) {
		this.jsDirectory = jsDirectory;
	}
	public String getCssDirectory() {
		return cssDirectory;
	}
	public void setCssDirectory(String cssDirectory) {
		this.cssDirectory = cssDirectory;
	}
	public String getLocaleDirectory() {
		return localeDirectory;
	}
	public void setLocaleDirectory(String localeDirectory) {
		this.localeDirectory = localeDirectory;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取flexpaper的config的json对象
	 * @return
	 */
	public String getConfig() {
		Map map = new HashMap();
		map.put("ElementId",getElementId());
		map.put("SwfFile",getSwfFile());
		map.put("PdfFile",getPdfFile());
		map.put("IMGFiles",getImgFiles());
		map.put("JSONFile",getJsonFile());
		map.put("useCustomJSONFormat",getUseCustomJSONFormat());
		map.put("JSONPageDataFormat",getJsonPageDataFormat());
		map.put("JSONDataType",getJsonDataType());
		map.put("Scale",getScale());
		map.put("ZoomTransition",getZoomTransition());
		map.put("ZoomTime",getZoomTime());
		map.put("ZoomInterval",getZoomInterval());
		map.put("FitPageOnLoad",getFitPageOnLoad());
		map.put("FitWidthOnLoad",getFitWidthOnLoad());
		map.put("FullScreenAsMaxWindow",getFullScreenAsMaxWindow());
		map.put("ProgressiveLoading",getProgressiveLoading());
		map.put("MinZoomSize",getMinZoomSize());
		map.put("MaxZoomSize",getMaxZoomSize());
		map.put("SearchMatchAll",getSearchMatchAll());
		map.put("SearchServiceUrl",getSearchServiceUrl());
		map.put("InitViewMode",getInitViewMode());
		map.put("BitmapBasedRendering",getBitmapBasedRendering());
		map.put("StartAtPage",getStartAtPage());
		map.put("PrintPaperAsBitmap",getPrintPaperAsBitmap());
		map.put("AutoAdjustPrintSize",getAutoAdjustPrintSize());
		map.put("EnableCornerDragging",getEnableCornerDragging());
		map.put("BackgroundColor",getBackgroundColor());
		map.put("PanelColor",getPanelColor());
		map.put("BackgroundAlpha",getBackgroundAlpha());
		map.put("UIConfig",getUiConfig());
		map.put("ViewModeToolsVisible",getViewModeToolsVisible());
		map.put("ZoomToolsVisible",getZoomToolsVisible());
		map.put("NavToolsVisible",getNavToolsVisible());
		map.put("CursorToolsVisible",getCursorToolsVisible());
		map.put("SearchToolsVisible",getSearchToolsVisible());
		map.put("StickyTools",getStickyTools());
		map.put("Toolbar",getToolbar());
		map.put("DocSizeQueryService",getDocSizeQueryService());
		map.put("RenderingOrder",getRenderingOrder());
		map.put("localeChain",getLocaleChain());
		map.put("jsDirectory",getJsDirectory());
		map.put("cssDirectory",getCssDirectory());
		map.put("localeDirectory",getLocaleDirectory());
		map.put("key",getKey());
		if(getConf() != null) {
			map.putAll(MapStrUtil.str2map(getConf()));
		}
		MapStrUtil.removeNullEntry(map);
		return MapStrUtil.map2str(map);
	}
	
	private void clearData() {
		elementId= null;
		swfFile= null;
		pdfFile= null;
		imgFiles= null;
		jsonFile= null;
		useCustomJSONFormat= null;
		jsonPageDataFormat= null;
		jsonDataType= null;
		scale= null;
		zoomTransition= null;
		zoomTime= null;
		zoomInterval= null;
		fitPageOnLoad= null;
		fitWidthOnLoad= null;
		fullScreenAsMaxWindow= null;
		progressiveLoading= null;
		minZoomSize= null;
		maxZoomSize= null;
		searchMatchAll= null;
		searchServiceUrl= null;
		initViewMode= null;
		bitmapBasedRendering= null;
		startAtPage= null;
		printPaperAsBitmap= null;
		autoAdjustPrintSize= null;
		enableCornerDragging= null;
		backgroundColor= null;
		panelColor= null;
		backgroundAlpha= null;
		uiConfig= null;
		viewModeToolsVisible= null;
		zoomToolsVisible= null;
		navToolsVisible= null;
		cursorToolsVisible= null;
		searchToolsVisible= null;
		stickyTools= null;
		toolbar= null;
		docSizeQueryService= null;
		renderingOrder= null;
		localeChain= null;
		jsDirectory= null;
		cssDirectory= null;
		localeDirectory= null;
		key= null;
		conf = null;
		style = null;
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getSwfFile() {
		return swfFile;
	}
	public void setSwfFile(String swfFile) {
		this.swfFile = swfFile;
	}
	public String getPdfFile() {
		return pdfFile;
	}
	public void setPdfFile(String pdfFile) {
		this.pdfFile = pdfFile;
	}
	public Double getScale() {
		return scale;
	}
	public void setScale(Double scale) {
		this.scale = scale;
	}
	public String getZoomTransition() {
		return zoomTransition;
	}
	public void setZoomTransition(String zoomTransition) {
		this.zoomTransition = zoomTransition;
	}
	public Double getZoomTime() {
		return zoomTime;
	}
	public void setZoomTime(Double zoomTime) {
		this.zoomTime = zoomTime;
	}
	public Double getZoomInterval() {
		return zoomInterval;
	}
	public void setZoomInterval(Double zoomInterval) {
		this.zoomInterval = zoomInterval;
	}
	public Boolean getFitPageOnLoad() {
		return fitPageOnLoad;
	}
	public void setFitPageOnLoad(Boolean fitPageOnLoad) {
		this.fitPageOnLoad = fitPageOnLoad;
	}
	public Boolean getFitWidthOnLoad() {
		return fitWidthOnLoad;
	}
	public void setFitWidthOnLoad(Boolean fitWidthOnLoad) {
		this.fitWidthOnLoad = fitWidthOnLoad;
	}
	public Boolean getFullScreenAsMaxWindow() {
		return fullScreenAsMaxWindow;
	}
	public void setFullScreenAsMaxWindow(Boolean fullScreenAsMaxWindow) {
		this.fullScreenAsMaxWindow = fullScreenAsMaxWindow;
	}
	public Boolean getProgressiveLoading() {
		return progressiveLoading;
	}
	public void setProgressiveLoading(Boolean progressiveLoading) {
		this.progressiveLoading = progressiveLoading;
	}
	public Double getMinZoomSize() {
		return minZoomSize;
	}
	public void setMinZoomSize(Double minZoomSize) {
		this.minZoomSize = minZoomSize;
	}
	public Double getMaxZoomSize() {
		return maxZoomSize;
	}
	public void setMaxZoomSize(Double maxZoomSize) {
		this.maxZoomSize = maxZoomSize;
	}
	public Boolean getSearchMatchAll() {
		return searchMatchAll;
	}
	public void setSearchMatchAll(Boolean searchMatchAll) {
		this.searchMatchAll = searchMatchAll;
	}
	public String getSearchServiceUrl() {
		return searchServiceUrl;
	}
	public void setSearchServiceUrl(String searchServiceUrl) {
		this.searchServiceUrl = searchServiceUrl;
	}
	public String getInitViewMode() {
		return initViewMode;
	}
	public void setInitViewMode(String initViewMode) {
		this.initViewMode = initViewMode;
	}
	public Boolean getBitmapBasedRendering() {
		return bitmapBasedRendering;
	}
	public void setBitmapBasedRendering(Boolean bitmapBasedRendering) {
		this.bitmapBasedRendering = bitmapBasedRendering;
	}
	public Integer getStartAtPage() {
		return startAtPage;
	}
	public void setStartAtPage(Integer startAtPage) {
		this.startAtPage = startAtPage;
	}
	public Boolean getPrintPaperAsBitmap() {
		return printPaperAsBitmap;
	}
	public void setPrintPaperAsBitmap(Boolean printPaperAsBitmap) {
		this.printPaperAsBitmap = printPaperAsBitmap;
	}
	public Boolean getAutoAdjustPrintSize() {
		return autoAdjustPrintSize;
	}
	public void setAutoAdjustPrintSize(Boolean autoAdjustPrintSize) {
		this.autoAdjustPrintSize = autoAdjustPrintSize;
	}
	public Boolean getEnableCornerDragging() {
		return enableCornerDragging;
	}
	public void setEnableCornerDragging(Boolean enableCornerDragging) {
		this.enableCornerDragging = enableCornerDragging;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getPanelColor() {
		return panelColor;
	}
	public void setPanelColor(String panelColor) {
		this.panelColor = panelColor;
	}
	public String getBackgroundAlpha() {
		return backgroundAlpha;
	}
	public void setBackgroundAlpha(String backgroundAlpha) {
		this.backgroundAlpha = backgroundAlpha;
	}
	public Boolean getViewModeToolsVisible() {
		return viewModeToolsVisible;
	}
	public void setViewModeToolsVisible(Boolean viewModeToolsVisible) {
		this.viewModeToolsVisible = viewModeToolsVisible;
	}
	public Boolean getZoomToolsVisible() {
		return zoomToolsVisible;
	}
	public void setZoomToolsVisible(Boolean zoomToolsVisible) {
		this.zoomToolsVisible = zoomToolsVisible;
	}
	public Boolean getNavToolsVisible() {
		return navToolsVisible;
	}
	public void setNavToolsVisible(Boolean navToolsVisible) {
		this.navToolsVisible = navToolsVisible;
	}
	public Boolean getCursorToolsVisible() {
		return cursorToolsVisible;
	}
	public void setCursorToolsVisible(Boolean cursorToolsVisible) {
		this.cursorToolsVisible = cursorToolsVisible;
	}
	public Boolean getSearchToolsVisible() {
		return searchToolsVisible;
	}
	public void setSearchToolsVisible(Boolean searchToolsVisible) {
		this.searchToolsVisible = searchToolsVisible;
	}
	public String getStickyTools() {
		return stickyTools;
	}
	public void setStickyTools(String stickyTools) {
		this.stickyTools = stickyTools;
	}
	public String getToolbar() {
		return toolbar;
	}
	public void setToolbar(String toolbar) {
		this.toolbar = toolbar;
	}
	public String getDocSizeQueryService() {
		return docSizeQueryService;
	}
	public void setDocSizeQueryService(String docSizeQueryService) {
		this.docSizeQueryService = docSizeQueryService;
	}
	public String getRenderingOrder() {
		return renderingOrder;
	}
	public void setRenderingOrder(String renderingOrder) {
		this.renderingOrder = renderingOrder;
	}
	public String getImgFiles() {
		return imgFiles;
	}
	public void setImgFiles(String imgFiles) {
		this.imgFiles = imgFiles;
	}
	public String getJsonFile() {
		return jsonFile;
	}
	public void setJsonFile(String jsonFile) {
		this.jsonFile = jsonFile;
	}
	public String getJsonPageDataFormat() {
		return jsonPageDataFormat;
	}
	public void setJsonPageDataFormat(String jsonPageDataFormat) {
		this.jsonPageDataFormat = jsonPageDataFormat;
	}
	public String getJsonDataType() {
		return jsonDataType;
	}
	public void setJsonDataType(String jsonDataType) {
		this.jsonDataType = jsonDataType;
	}
	public String getUiConfig() {
		return uiConfig;
	}
	public void setUiConfig(String uiConfig) {
		this.uiConfig = uiConfig;
	}
}
