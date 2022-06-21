<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.e.commerce.model.Categorie" %>

<div class="card-body">
        <h3 style="color: #1b223c;">Ajout de nouvelle Produit</h3>
        <sf:form method="POST" modelAttribute="Produit" action="AjoutProduit" cssClass="col-md-8">
        <div class="form-group">
            <label for="exampleFormControlInput1">Nom</label>
            <sf:input path="nom" cssClass="form-control" id="exampleFormControlInput1" placeholder="Nom du produit"/>
        </div>
        <div class="form-group">
            <label for="Prix">Prix</label>
            <sf:input path="prix" cssClass="form-control" id="exampleFormControlInput2" type="number"/>
        </div>
        <div class="form-group">
            <label for="Description">Description</label>
            <sf:textarea path="description" cssClass="form-control" rows="3"></sf:textarea>
        </div>
        <div class="form-group">
            <label for="categorieMere">Categorie</label>
            <select class="form-control" id="categorieMere" name="categorie" onchange="souscat(this.value)">
                <c:forEach items="${requestScope.categorie}" var="lists">
                    <option value="${lists.getId()}"> ${lists.getNom()}</option>
                </c:forEach>
            </select>
        </div>
            <div class="form-group">
                <p style="color: black;">vous pouvez choisir plusieurs sous categorie en maintenant  ctrl + click</p>
                <label for="SousCategorie">Sous categorie</label>
                <select class="js-example-basic-multiple form-control" name="categorie[]" multiple="multiple" id="SousCategorie">
                    <option value="" selected>ajouter un sous categorie</option>
                </select>
            </div>
        <div class="form-footer pt-4 pt-5 mt-4 border-top">
            <button type="submit" class="btn btn-primary btn-default">Submit</button>
            <button type="submit" class="btn btn-secondary btn-default">Cancel</button>
        </div>
        </sf:form>
    <div style="color: red"> <c:out value="${ error }"></c:out> </div>
    <div style="color: green"> <c:out value="${ success }"></c:out> </div>
</div>

<script >

    function souscat(str)
    {
        if(str.length == 0){
        } else {
            // AJAX REQ
            var sous=document.getElementById("SousCategorie");
            while(sous.firstChild)
            {
                sous.removeChild(sous.lastChild);
            }
            var http_request = new XMLHttpRequest();
            http_request.onreadystatechange = function(){
                if (http_request.readyState == 4  ) {
                    // Javascript function JSON.parse to parse JSON data
                    var jsonObj = JSON.parse(http_request.responseText);
                    var option1=document.createElement("option");
                    option1.value="";
                    option1.innerHTML="ajouter un sous categorie";
                    option1.selected=true;
                    sous.appendChild(option1);
                    // jsonObj variable now contains the data structure and can
                    // be accessed as jsonObj.name and jsonObj.country.
                    for (var i = 0; i < jsonObj.length; i++) {
                        var vao=document.createElement("option");
                        vao.value=jsonObj[i].id;
                        vao.innerHTML=jsonObj[i].nom;
                        sous.appendChild(vao);
                    }
                }
            }
            var path='<c:out value="${pageContext.request.contextPath}/categorie/categories/"/>';
            http_request.open("GET", path+str, true);
            http_request.send();
        }
    }


</script>
