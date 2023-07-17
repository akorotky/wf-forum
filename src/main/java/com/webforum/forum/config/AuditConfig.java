package com.webforum.forum.config;//package com.webforum.forum.config;
//
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.lang.NonNull;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.Optional;
//
//public class AuditConfig implements AuditorAware<Long> {
//
//    @Override
//    public @NonNull Optional<Long> getCurrentAuditor() {
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(SecurityContext::getAuthentication)
//                .filter(Authentication::isAuthenticated)
//                .map(Authentication::getPrincipal)
//                .map(UserPrincipal.class::cast)
//                .map(UserPrincipal::getId);
//    }
//}
