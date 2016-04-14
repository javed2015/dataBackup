

function GetXMLString(gridobj) {
	var colCount;
	gridobj.editStop();
	var xmlstr = "<rows>";
	for (var i = 0; i < gridobj.getRowsNum(); i++) {
		xmlstr = xmlstr + "<row>";
		colCount = 0;
		for (var j = 0; j < gridobj.getColumnCount(); j++) {
			xmlstr = xmlstr + "<cell" + colCount + ">"
					+ gridobj.cells(gridobj.getRowId(i), j).getValue()
					+ "</cell" + colCount + ">";
			colCount = colCount + 1;
		}
		xmlstr = xmlstr + "</row>";
	}
	xmlstr = xmlstr + "</rows>";
	return xmlstr;
}

