function _textEventHandler(el) {
	this.docElement = el;
}

_textEventHandler.prototype.attachEvents = function()
{
	el = this.docElement;
	el.addEventListener('mouseup', this.doMouseUp, false);
}

_textEventHandler.prototype.detachEvents = function() {
	el = this.docElement;
	el.removeEventListener('mouseup',this.doMouseUp, false);
}

/*_textEventHandler.prototype.defaultfn = function() {
	console.log("detached events");
}*/

function __addTextSelection() {
	var el = document.getElementById("lydata");
	var _elinit = new _elementEventHandler(el);
	_elinit.detachEvents();
	var _init = new _textEventHandler(el);
	_init.attachEvents();
}

function textSelection(range, anchorNode, focusNode) {
	this.range = range;
	this.type = 3;
	this.rCollection = [];
	this.textContent = encodeURI(range.toString());
	this.anchorNode = anchorNode;
	this.focusNode = focusNode;
	this.selectionId = getRandom();
	this.yPOS = getYPOS();
	
	this.getTagName = function(range) {var el = range.startContainer.parentNode; return el;}
	this.getTagIndex = function(el) {var index = $(el.tagName).index(el); return index;}
	
	this.simpleText = function(node, range) {
		if(!node)
			var entry = this.createEntry(this.anchorNode, this.range);
		else
			var entry = this.createEntry(node, range);
		this.rCollection.push(entry);
		this.highlight(this.rCollection[0].range);
		this.crossIndexCalc();
		textSelection._t_list.push(this);
		pushto_G_FactualEntry(this);
	}
	
	this.compositeText = function(){
		this.findSelectionDirection();
		var flag = this.splitRanges(this.anchorNode, this.focusNode, this.range.startOffset, this.range.endOffset);
		if(flag == 0) {
			for(j in this.rCollection) {
				this.highlight(this.rCollection[j].range);
			}
		}
		this.crossIndexCalc();
		textSelection._t_list.push(this);
		pushto_G_FactualEntry(this);
	}
}

textSelection._t_list = [];

textSelection.prototype.findSelectionDirection = function() {
	var tempanchor = this.findParentNode (this.anchorNode, this.range.commonAncestorContainer);
	var tempfocus = this.findParentNode (this.focusNode, this.range.commonAncestorContainer);
	var lenAnchor = this.nodeCount(tempanchor, this.range.commonAncestorContainer);
	var lenFocus = this.nodeCount(tempfocus, this.range.commonAncestorContainer);
	if(lenAnchor > lenFocus) {
		var temp = this.anchorNode;
		this.anchorNode = this.focusNode;
		this.focusNode = temp;
	}
}

textSelection.prototype.findParentNode = function(node, commonNode) {
	var pn = node;
	var currNode = pn;
	while (pn != commonNode) {
		currNode = pn;
		pn = pn.parentNode;
	}
	return currNode;
}

textSelection.prototype.nodeCount = function(node, commonNode) {
	var length = commonNode.childNodes.length;  // commonnode must be a element node;
	var childrens = commonNode.childNodes;
	for(var nodeCount = 0; nodeCount < length; nodeCount++) {
		if(childrens[nodeCount] == node) {
			return nodeCount;     // returning node count from commonnode
		}
	}
	return (-1);     // commonnode does not contain particular node
}

textSelection.prototype.createEntry = function(node, range) {
	var el = this.getTagName(range);
	var entry = {};
	entry.range = range;
	entry.node = node;
	entry.tagName = el.tagName;
	entry.tagIndex = this.getTagIndex(el);
	entry.data = encodeURI(range.toString());
	entry.nodeType = node.nodeType;
	entry.sIdx = range.startOffset;
	entry.eIdx = range.endOffset;
	entry.fontColor = lynked_fontColor;
	entry.bgColor = lynked_bgColor;
	return entry;
}

textSelection.prototype.highlight = function(range) {
	if (range.pasteHTML) {
		range.pasteHTML('<span id= "span1" class="hilited1">'
				+ range.text
				+ '</span>');
	} else {
		var newNode = $('<factual id= "span1" style= "color:'+lynked_fontColor+';background-color:'+lynked_bgColor+';" />')[0];
		range.surroundContents(newNode);
	}
}

textSelection.prototype.splitRanges = function(anchornode, focusnode, startOffset, endOffset) {
	var stop = 0;
	var lastParent = anchornode;
	var node = anchornode;
	while (stop == 0) {
		if (node.nodeType == 3) {
			stop = this.testEnd(node, focusnode, startOffset, endOffset);
			startOffset = 0;
		}

		if (stop == 1) {
			return 0;
		}
		if (node.nodeType == 1 && node != lastParent) {
		
			if (node.firstChild) {
				node = node.firstChild;
				while (node.nodeType == 1) {
					node = node.firstChild;
				}
			}
		
			if (node.nodeType == 3) {
				stop = this.testEnd(node, focusnode, startOffset, endOffset);
			}

		}
		if (node.nextSibling && node.nextSibling != lastParent) {
			node = node.nextSibling;
		} else if (node.parentNode.nextSibling
				&& node.parentNode.nextSibling != lastParent) {
			lastParent = node.parentNode;
			node = node.parentNode.nextSibling;
		} else {
			node = node.parentNode;
			lastParent = node;
		}
	}
	return 0;
}

textSelection.prototype.testEnd = function(anchornode, focusnode, startOffset, endOffset) {
	if (anchornode == focusnode) {
		var node = focusnode;
		this.addRange(node, startOffset, endOffset);
		return 1;
	} else {
		var node = anchornode;
		endOffset = node.data.length;
		this.addRange(node, startOffset, endOffset);
		return 0;
	}
}

textSelection.prototype.addRange = function(node, startOffset, endOffset) {
	var textRange = document.createRange();
	textRange.setStart(node, startOffset);
	textRange.setEnd(node, endOffset);	
	var entry = this.createEntry(node, textRange);
	this.rCollection.push(entry);
}

textSelection.prototype.crossIndexCalc = function() {
	var j = 0;
	while(j < this.rCollection.length) {
		currObj = this.rCollection[j];
		var k = 0, len = 0;
		var childrens = currObj.range.startContainer.childNodes;
		var length = currObj.range.startContainer.childNodes.length;
		while (k < length) {
			if (childrens[k].nodeType == 1 && childrens[k].id == 'span1') {
				currChild = childrens[k].childNodes;
				var kk = 0, sIdx = 0, eIdx = 0;
				while (kk < childrens[k].childNodes.length) {
					if (currChild[kk].nodeType == 3) {
						var textRange = document.createRange();
						textRange.selectNode(currChild[kk].parentNode);
						if (currChild[kk].data.trim() == decodeURI(currObj.data).trim() /*currObj.data.trim()*/ && textRange.startOffset == currObj.range.startOffset) {
							sIdx = len;
							len = len + currChild[kk].data.length;
							eIdx = len;
							currObj.sIdx = sIdx;
							currObj.eIdx = eIdx;
							break;
						}
						else {
							len = len + currChild[kk].data.length;
						}
					}
					kk++;
				}
				k++;
			} else if (childrens[k].nodeType == 3) {
				len = len + childrens[k].data.length;
				k++;
			} else {
				k++;
			}
		}
		j++;
	}
}


_textEventHandler.prototype.doMouseUp = function() {
	if (window.getSelection) { // all browsers, except IE
		// before version 9
		var userSelection = window.getSelection();
		var _wSelection = new _windowSelection(userSelection, userSelection.anchorNode, userSelection.focusNode);
		var range = _wSelection.getRange();
		userSelection.removeAllRanges();
		if(!range.collapsed) {
			var _rSelction = new textSelection(range, _wSelection.anchorNode, _wSelection.focusNode);
			if(_wSelection.anchorNode == _wSelection.focusNode) {
				_rSelction.simpleText();
			}
			else {
				_rSelction.compositeText();
			}
		}
		else {
			console.log("empty");
		}
	}
	else {
		alert("Your browser does not support user selection!");
	}
}

function _windowSelection(userSelection, anchorNode, focusNode) {
	this.userSelection = userSelection;
	this.anchorNode = anchorNode;
	this.focusNode = focusNode;
	/*this.anchornode = function() {
		return this.anchorNode;
	}*/
}

_windowSelection.prototype.getRange = function() {
	if (this.userSelection.getRangeAt) {
		var range = this.userSelection.getRangeAt(0);
		return range;
	} else { // Safari!
		var range = document.createRange();
		range.setStart(this.anchorNode, this.userSelection.anchorOffset);
		range.setEnd(this.focusNode, this.userSelection.focusOffset);
		return range;
	}
}

textSelection.prototype.removeSelection = function(entry) {
	var i = 0;
	var currObj = null, currIndex = 0;
	while(i < textSelection._t_list.length){
		//console.log("selecitonId: " + entry.selectionId + "  " + textSelection._t_list[i].selectionId);
		if(entry.selectionId == textSelection._t_list[i].selectionId) {
			currObj = textSelection._t_list[i];
			currIndex = i;
		}
		i++;
	}
	if(currObj != null) {
		textSelection._t_list.splice(currIndex, 1);
		var j = 0;
		while (j < currObj.rCollection.length) {
			var obj = currObj.rCollection[j];
			var k = 0;
			
			if(obj.range.startContainer.childNodes) {
				var childrens = obj.range.startContainer.childNodes;
				var length2 = obj.range.startContainer.childNodes.length;    // consider this code and length2 variable
			}
			var test = 0;
			while (k < length2 ) {
				var currNode = childrens[k];
				if (currNode.nodeType == 1 && currNode.id == "span1"
					&& decodeURI(obj.data) == childrens[k].textContent) {
					
					nodeToBeReplaced = currNode;
					node = currNode.firstChild;
					
					var replaceNode = document
							.createTextNode(currNode.textContent);
					nodeToBeReplaced.parentNode.replaceChild(replaceNode,
							nodeToBeReplaced);
					obj.range.selectNode(replaceNode);
					test = 1;
					break;
				}
				k++;
			}
			if(test == 0)
				j++;
		}
	}
}

textSelection.prototype.insertSelection = function(entry) {
	textSelection._t_list.push(entry);
	var i = 0;
	//console.log("insert: " + entry.anchorNode + "  " + entry.rCollection.length);
	var length =  entry.rCollection.length;
	 var temp_fcolor = lynked_fontColor;
	 var temp_bcolor = lynked_bgColor;
	while (i < length) {
		//console.log("insert: " + i + "  " + entry.rCollection[i].range);
		lynked_fontColor = entry.rCollection[i].fontColor;
		lynked_bgColor = entry.rCollection[i].bgColor;
		this.highlight(entry.rCollection[i].range);
		i++;
	}
	lynked_fontColor = temp_fcolor;
	lynked_bgColor = temp_bcolor;
}

textSelection.prototype.retrieveSelection = function(entry) {
	var length = entry.rCollection.length;
	for(var i = 0; i < length; i++) {
		var currNode = document.getElementsByTagName(entry.rCollection[i].tagName).item(entry.rCollection[i].tagIndex);
		var currData = decodeURI(entry.rCollection[i].data);
		var fIndex = entry.rCollection[i].sIdx;
		var nodeType = entry.rCollection[i].nodeType;
		lynked_fontColor = entry.rCollection[i].fontColor;
		lynked_fontColor = lynked_fontColor.split("lynk_space").join("");
		lynked_bgColor = entry.rCollection[i].bgColor;
		lynked_bgColor = lynked_bgColor.split("lynk_space").join("");
		this.findNode(currNode, currData, fIndex, nodeType);
	}
	return this;
}

textSelection.prototype.findNode = function(node, data, fIndex, nodeType) {
	var currData = data;
	currData = currData.split("lynk_space").join(" ");
	//console.log("currData:  " + currData);
	currData = currData.split("lynk_endtag").join(">");
	//console.log("currData:  " + currData);
	var localLen = 0, flag = 0;
	var childrens = node.childNodes;
	for (var j = 0; j < node.childNodes.length; j++) {
		if (childrens[j].nodeType == 1) {
			if (childrens[j].id == 'span1' && nodeType == 3
					/*&& childrens[j].firstChild.nodeType != 1*/) {
				var text = childrens[j].firstChild;
				localLen = localLen + text.length;
			}

		} else {
			var fIdx = fIndex - localLen;
			localLen = localLen + childrens[j].length;
			if (fIndex < localLen) {
				this.innerSearch(childrens[j], currData, fIdx);
				break;
			}
		}
	}
}

textSelection.prototype.innerSearch = function(node, data, fIndex){
	var fIdx, eIdx, rText, text, midText, rNode, midNode, lNode;
	if (node.nodeType === 3) {
		text = node.textContent;
		if (text.indexOf(data) > -1) {
			fIdx = fIndex;
			eIdx = fIdx + data.length;
			rText = text.substring(fIdx);
			midText = text.substring(fIdx, eIdx);
			lNode = node.splitText(fIdx);
			rNode = lNode.splitText(data.length);
			midNode = lNode;
			//var spanNode = document.createElement('span');
			var spanNode = document.createElement('factual');
			console.log("f:  " + lynked_fontColor + " b: " + lynked_bgColor);
			spanNode.style.background = lynked_bgColor;
			spanNode.style.color = lynked_fontColor;
			spanNode.className = 'hilited1';
			spanNode.id = 'span1';
			var midNodeClone = midNode.cloneNode(true);
			spanNode.appendChild(midNodeClone);
			midNode.parentNode.replaceChild(spanNode, midNode);
			// console.log("findex: " + fIdx + "\ntext: " + midNode.nodeValue +
			// "\neindex: " + eIdx);
		}
	}
}

function lynkedUndo() {
	if(_xxgTOPxx_ != -1)
		var entry = popfrom_G_FactualEntry();
	else {
		alert("nothing to undo");
		return;
	}
	
	if(entry.type == 3) {
		pushto_R_FactualEntry(entry);
		var _textSel = new textSelection(entry.range, entry.anchorNode, entry.focusNode); //object creation without parameter Constructor
		_textSel.removeSelection(entry);
	}
	else {
		pushto_R_FactualEntry(entry);
		var _elSel = new _elementSelection(); //object creation without parameter Constructor
		_elSel.removeSelection(entry.el, 1);
	}
	if(_xxgTOPxx_ != -1)
		window.scrollTo(0, globalSelection[_xxgTOPxx_ ].yPOS);
	else 
		window.scrollTo(0, retrieveSelection[_xxrTOPxx_].yPOS);
}

function lynkedRedo(){
	if(_xxrTOPxx_ != -1)
		var entry = popfrom_R_FactualEntry();
	else {
		alert("nothing to redo");
		return;
	}
	
	if(entry.type == 3) {
		pushto_G_FactualEntry(entry);
		var _textSel = new textSelection(entry.range, entry.anchorNode, entry.focusNode); //object creation without parameter Constructor
		_textSel.insertSelection(entry);
	}
	else {
		pushto_G_FactualEntry(entry);
		var _elSel = new _elementSelection();
		_elSel.loadSelection(entry);
	}
	
	window.scrollTo(0,globalSelection[_xxgTOPxx_].yPOS);
}

function getYPOS()
{
	
  var ypos = $(document).scrollTop();
  console.log(ypos);
  return ypos;
}

function heightConfigure() {
	var leastHeight = globalSelection[0].yPOS;
	var i = 1;
	while(i <= _xxgTOPxx_) {
		if(leastHeight > globalSelection[i].yPOS) {
			leastHeight = globalSelection[i].yPOS;
		}
		i++;
	}
	return leastHeight;
}

function setToken(token) {
	document.getElementById("lynk_token1").value = token;
	// console.log("set: "+ token);
}


var globalSelection = []; 
var retrieveSelection = [];
var _xxgTOPxx_ = -1, _xxrTOPxx_ = -1;

function getRandom() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
    }
    return s4() + s4();
}


function pushto_G_FactualEntry(entry) {
	_xxgTOPxx_ = _xxgTOPxx_ + 1;
	globalSelection.push(entry);
}

function pushto_R_FactualEntry(entry) {
	_xxrTOPxx_ = _xxrTOPxx_ + 1;
	retrieveSelection.push(entry);
}

function removefrom_G_FactualEntry(entry) {
	for(var i = 0; i <= _xxgTOPxx_  ; i++){
		if(globalSelection[i].selectionId == entry.selectionId) {
			globalSelection.splice(i, 1);
			_xxgTOPxx_ = _xxgTOPxx_ - 1;
			break;
		}
	}
}

function removefrom_R_FactualEntry() {
	retrieveSelection.splice(_xxrTOPxx_, 1);
	_xxrTOPxx_ = _xxrTOPxx_ - 1;
}

function popfrom_G_FactualEntry() {
	var entry = globalSelection[_xxgTOPxx_];
	removefrom_G_FactualEntry(entry);
	//pushto_R_FactualEntry(entry);
	return entry;
}

function popfrom_R_FactualEntry() {
	var entry = retrieveSelection[_xxrTOPxx_];
	removefrom_R_FactualEntry(entry);
	//pushto_G_FactualEntry(entry);
	return entry;
}

function _elementEventHandler(el) {
	this.docElement = el;
}

function _elementSelection() {  
	this.el;
	this.tagName;
	this.tagIndex;
	this.type;
	this.data;
	this.selectionId;
	this.yPOS;
}
_elementSelection._el_list = [];
_elementSelection.size = 0;


_elementSelection.prototype.addSelection = function(el) {
	this.el = el;
	this.tagName = el.tagName;
	this.tagIndex = $(el.tagName).index(el);
	this.type = el.ELEMENT_NODE;
	this.data = el.textContent;
	this.selectionId = getRandom();
	this.yPOS = getYPOS();
	
	_elementSelection._el_list.push(this);
	pushto_G_FactualEntry(this);
	_elementSelection.size = this.size + 1;
}

_elementSelection.prototype.removeSelection = function(el, offset) {
	var tagName = el.tagName;
	var tagIndex = $(el.tagName).index(el);
	var currIndex = -1;
	for(i in _elementSelection._el_list) {
		if(_elementSelection._el_list[i].tagName == tagName){
			if(_elementSelection._el_list[i].tagIndex == tagIndex) {
				currIndex = i;
				break;
			}
		}
	}
	//console.log("deleted Element: " + _elementSelection._el_list[currIndex])
	if(currIndex != -1){
		//var currTop = _elementSelection._el_list[currIndex].selectionIndex;
		var elementToBeRemoved = _elementSelection._el_list[currIndex];
		_elementSelection._el_list.splice(currIndex, 1);
		_elementSelection.size = this.size - 1;
		if(offset == 0) {
			//console.log("removeselecion:  "  + elementToBeRemoved);
			removefrom_G_FactualEntry(elementToBeRemoved);
		}
		else {
			el.classList.remove("rcorners12");
			if(el.classList.contains("rcorners11")) el.classList.remove("rcorners11");
			el.setAttribute("_xxFactualNotexx_",0);
		}
	}
}

_elementSelection.prototype.displaySelection = function() {
	console.log("selection to displayed:");
	for(var i = 0; i < _elementSelection._el_list.length; i++) {
		console.log("el_list:");
		console.log(_elementSelection._el_list[i]);
	}
}

_elementEventHandler.prototype.attachEvents = function() {
	el = this.docElement;
	el.addEventListener('mouseover', this.doMouseOver, false);
	el.addEventListener('mouseout', this.doMouseOut, false);
	el.addEventListener('click', this.doMouseClick, false);
}

_elementEventHandler.prototype.detachEvents = function() {
	el = this.docElement;
	el.removeEventListener('mouseover',this.doMouseOver, false);
	el.removeEventListener('mouseout',this.doMouseOut, false);
	el.removeEventListener('click',this.doMouseClick, false);
}
/*_elementEventHandler.prototype.defaultfn = function() {
	console.log("detached events");
}*/

_elementSelection.prototype.loadSelection = function(entry) {
	this.tagName = entry.tagName;
	this.tagIndex = entry.tagIndex;
	this.el = document.getElementsByTagName(entry.tagName).item(entry.tagIndex);
	this.data = entry.data;
	this.type = entry.type;
	this.selectionId = entry.selectionId;
	
	this.el.classList.add("rcorners12");
	this.el.setAttribute("_xxFactualNotexx_",1);
	_elementSelection._el_list.push(this);
	return this;
}

function __addElementSelection() {
	var el = document.getElementById("lydata");
	var _txtinit = new _textEventHandler(el);
	_txtinit.detachEvents();
	var _elinit = new _elementEventHandler(el);
	_elinit.attachEvents();
}

_elementEventHandler.prototype.doMouseOver = function (e) {
	/*if (!e) var e = window.event;
	var relTarg = e.relatedTarget || e.toElement;*/
	//console.log("doMouseOver:  " + e + "  " + relTarg);
	var elem = e.target;
	if(elem != document.getElementById("lydata")) {
		if(elem.getAttribute("_xxFactualNotexx_") == null || elem.getAttribute("_xxFactualNotexx_") == 0) {
			elem.setAttribute("_xxFactualNotexx_",0);
			if(elem.classList.contains("rcorners11")) elem.classList.remove("rcorners11");
			elem.classList.add("rcorners12");
		}
	}   
}

_elementEventHandler.prototype.doMouseOut = function (e) {
	var elem = e.target;
	if(elem != document.getElementById("lydata")) {
		if(elem.getAttribute("_xxFactualNotexx_") == 0) {
			if(elem.classList.contains("rcorners12")) elem.classList.remove("rcorners12");
			elem.classList.add("rcorners11");
		}
	}
}

_elementEventHandler.prototype.doMouseClick = function (e) {
	var elem = e.target;
	if(elem != document.getElementById("lydata")) {
		if(elem.getAttribute("_xxFactualNotexx_") == 0) {
			if(elem.classList.contains("rcorners11")) elem.classList.remove("rcorners11");
			elem.classList.add("rcorners12");
			elem.setAttribute("_xxFactualNotexx_",1);
			var obj = new _elementSelection();
			obj.addSelection(elem);
			obj.displaySelection();
		}
		else {
			elem.classList.remove("rcorners12");
			if(elem.classList.contains("rcorners11")) elem.classList.remove("rcorners11");
			elem.setAttribute("_xxFactualNotexx_",0);
			var obj = new _elementSelection();
			obj.removeSelection(elem, 0);
		}
	}
}

function submitSelection() {
	var lynk_url, jsonBody, lynk_dummy1, lynk_dummy2, lynk_name, lynk_desc, lynk_flag;
	var selections = FJSON.stringify(globalSelection);
	lynk_dummy1 = heightConfigure();
	lynk_url = document.getElementById("lynk_url").value;
	document.getElementById("lynk_dummy1").value = lynk_dummy1;
	lynk_dummy2 = document.getElementById("lynk_dummy2").value;
	lynk_name = document.getElementById("lynk_name").innerHTML;
	lynk_desc = document.getElementById("lynk_desc").innerHTML;
	lynk_flag = $('#lynk_flag:checked').val();
	if (document.getElementById("lynk_flag1").checked == true) {
		lynk_flag = "private";
	} else {
		lynk_flag = "public";
	}
	//console.log(globalSelection);
	/*modified by javed start 14-03-16*/
	jsonBody = 'storedSelections='+encodeURI(selections)+
				'&lynk_url='+lynk_url+
	'&lynk_dummy1='+lynk_dummy1+
	'&lynk_dummy2='+lynk_dummy2+
	'&lynk_name='+lynk_name+
	'&lynk_desc='+lynk_desc+
	'&lynk_flag='+lynk_flag;
	$.ajax({
		async : false,
		type: "POST",
	     url: 'DataServlet', 
	    data: jsonBody,
		success : function(data) {
			setToken(data);
		},
		error : function(data, status, er) {
			alert("error: " + data + " status: " + status + " er:" + er);
		}
	});
	/*modified by javed end 14-03-16*/
}

function refresh() {
	var data = document.getElementById("lynk_data").value;
	var jsonData = FJSON.parse(data);
	//console.log(jsonData + "  " + jsonData.length);
	for (var j = 0; j < jsonData.length; j++) {
		if (jsonData[j].type == 1) {
			console.log(jsonData[j].el);
			var el_sel = new _elementSelection();
			var entry = el_sel.loadSelection(jsonData[j]);
			pushto_G_FactualEntry(entry);
		} else {
			var textSel = new textSelection(jsonData[j].range,
					jsonData[j].anchorNode, jsonData[j].focusNode);
			var entry = textSel.retrieveSelection(jsonData[j]);
			pushto_G_FactualEntry(entry);
		}
	}
}
var lynked_fontColor,lynked_bgColor;
$(document).ready(function() {
	lynkeddefColor();
	$('#lynked-undo').click(function() {
		if (lj.menuCheck()) 
		lynkedUndo();
	});
	$('#lynked-redo').click(function() {
		if (lj.menuCheck()) 
		lynkedRedo();
	});
	$('#Lynked-textMarker').click(function() {
		if (lj.menuCheck()){
			$('#lydata').css('cursor', 'text');
			__addTextSelection();
		}
	});
	$('#Lynked-brushMarker').click(function() {
		if (lj.menuCheck()){
			$('#lydata').css('cursor', 'text');
			__addTextSelection();
		}
	});
	$('#Lynked-elementMarker').click(function() {
		if (lj.menuCheck()) {
			$('#lydata').css('cursor', 'default');
			__addElementSelection();
		}
	});
	/*color select*/
	function lynkeddefColor(){
		lynked_fontColor = $('.lynked-textColor').css("background-color");
		lynked_bgColor = $('.lynked-highlighterColor').css("background-color");
	}
	$('#Lynked-colorSelector').click(function(){
		lynked_fontColor = $('.lynked-textColor').css("background-color");
		lynked_bgColor = $('.lynked-highlighterColor').css("background-color");
	});
});