package com.capstone.backend.security.filter;

//public class ExceptionHandlerFilter {
//
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            filterChain.doFilter(request, response);
//        } catch (EntityNotFoundException e) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            response.getWriter().write("Username not found");
//            response.getWriter().flush();
//        } catch (JWTVerificationException e) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            response.getWriter().write("JWT NOT VALID");
//            response.getWriter().flush();
//        } catch (RuntimeException e) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write("BAD REQUEST");
//            response.getWriter().flush();
//        }
//    }
//}