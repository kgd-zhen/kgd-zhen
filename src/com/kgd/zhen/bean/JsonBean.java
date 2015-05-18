package com.kgd.zhen.bean;

import java.util.List;

public class JsonBean {
	@Override
	public String toString() {
		 return "JsonBean [segment=" + segment + "]"; 
	}

	public Segment segment;
	public Segment getSegment() {
		return segment;
	}
	public void setSegment(Segment segment) {
		this.segment = segment;
	}


	public static class Segment{
		@Override
		public String toString() {
			 return "Segment [type=" + type + ", description=" + description  
	                    + ", dataset=" + dataset + ", metadata=" + metadata 
	                    + ",lines"+lines+"]"; 
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDataset() {
			return dataset;
		}
		public void setDataset(String dataset) {
			this.dataset = dataset;
		}
		public List<Metadata> getMetadata() {
			return metadata;
		}
		public void setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
		}
		public Lines getLines() {
			return lines;
		}
		public void setLines(Lines lines) {
			this.lines = lines;
		}
		public String type;
		public String description;
		public String dataset;
		public List<Metadata> metadata;
		public Lines lines;
	}
	
	public static class Metadata{
		@Override
		public String toString() {
			 return "Metadata [label=" + label + ", type=" + type  
	                    + ", key=" + key + ", align=" + align 
	                    + ",length" + length + ",digit" + digit
	                    + ",maxlength" + maxlength + "]"; 
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getAlign() {
			return align;
		}
		public void setAlign(String align) {
			this.align = align;
		}
		public String getLength() {
			return length;
		}
		public void setLength(String length) {
			this.length = length;
		}
		public String getDigit() {
			return digit;
		}
		public void setDigit(String digit) {
			this.digit = digit;
		}
		public String getMaxlength() {
			return maxlength;
		}
		public void setMaxlength(String maxlength) {
			this.maxlength = maxlength;
		}
		public String label;
		public String type;
		public String key;
		public String align;
		public String length;
		public String digit;
		public String maxlength;
	}
	
	public static class Lines{
		@Override
		public String toString() {
			 return "Lines [line=" + line + "]";
		}

		public Line getLine() {
			return line;
		}

		public void setLine(Line line) {
			this.line = line;
		}

		public Line line;

	}
	
	public static class Line{
		@Override
		public String toString() {
			return "Line [fontsize=" + fontsize + ", content="  
	                + content + "]"; 
		}
		public String getFontsize() {
			return fontsize;
		}
		public void setFontsize(String fontsize) {
			this.fontsize = fontsize;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String fontsize;
		public String content;		
	}
	
}
