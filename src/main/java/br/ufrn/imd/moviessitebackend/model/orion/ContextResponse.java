package br.ufrn.imd.moviessitebackend.model.orion;

public class ContextResponse {
    private ContextElement contextElement;
    private StatusCode statusCode;

    public ContextResponse(ContextElement contextElement, StatusCode statusCode) {
        this.contextElement = contextElement;
        this.statusCode = statusCode;
    }

    public ContextElement getContextElement() {
        return contextElement;
    }

    public void setContextElement(ContextElement contextElement) {
        this.contextElement = contextElement;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
