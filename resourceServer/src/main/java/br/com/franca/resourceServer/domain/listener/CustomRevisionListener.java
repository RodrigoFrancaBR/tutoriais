package br.com.franca.resourceServer.domain.listener;

import br.com.franca.resourceServer.domain.model.CustomRevisionEntity;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity cre = (CustomRevisionEntity)revisionEntity;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        Object details = auth.getDetails();

        if (principal instanceof OAuth2IntrospectionAuthenticatedPrincipal)
            cre.setUsuario(((OAuth2IntrospectionAuthenticatedPrincipal) principal).getClientId());

        if (details instanceof WebAuthenticationDetails)
            cre.setIp(((WebAuthenticationDetails) details).getRemoteAddress());

    }
}
